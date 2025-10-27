const fs = require('fs');
const path = require('path');

const repoRoot = path.resolve(__dirname, '..');
const readmePath = path.join(repoRoot, 'README.md');

// Topics to track (add/remove names to match your folders)
const topics = ['Arrays', 'Trees', 'DP', 'LinkedList'];

function countFilesInDir(dirPath) {
	// count regular files only, skip README.md and hidden files
	if (!fs.existsSync(dirPath)) return 0;
	return fs.readdirSync(dirPath, { withFileTypes: true })
		.filter(d => d.isFile() && d.name.toLowerCase() !== 'readme.md' && !d.name.startsWith('.'))
		.length;
}

function makeAsciiBar(count) {
	// limit bar length to 60 for very large counts (scale if needed)
	const maxLen = Math.min(count, 60);
	return '█'.repeat(maxLen);
}

function buildStatsBlock(counts) {
	const lines = [];
	lines.push('### 📊 Live Topic Growth Chart (auto-updated on push)\n');
	lines.push('Current counts (problems solved)');
	for (const t of Object.keys(counts)) {
		lines.push(`- ${t}: ${counts[t]}`);
	}
	lines.push('\nASCII bar chart (1 block = 1 problem)');
	lines.push('```');
	for (const t of Object.keys(counts)) {
		const name = t.padEnd(6, ' ');
		const cnt = counts[t];
		const bar = makeAsciiBar(cnt);
		lines.push(`${name} | ${cnt} ${bar}`);
	}
	lines.push('```\n');
	lines.push('Optional Mermaid bar chart (may not render on all platforms)');
	lines.push('```mermaid');
	lines.push('%%{init: {\'theme\': \'default\'}}%%');
	lines.push('bar');
	lines.push('  title Problems per Topic (counts)');
	for (const t of Object.keys(counts)) {
		lines.push(`  "${t}": ${counts[t]}`);
	}
	lines.push('```');
	lines.push('\nNote: This section is maintained automatically by .github/workflows/update-readme.yml using scripts/update_stats.js — do not edit manually.');
	return lines.join('\n');
}

function updateReadme(counts) {
	let content = fs.readFileSync(readmePath, 'utf8');

	// Update the Topic Coverage table numeric column for each topic (multiline, case-insensitive)
	for (const t of Object.keys(counts)) {
		// Replace the number after "| <Topic> | <number>"
		const re = new RegExp(`(^\\|\\s*${t}\\s*\\|\\s*)\\d+`, 'mi');
		content = content.replace(re, `$1${counts[t]}`);
	}

	// Replace the STATS block between markers
	const startMarker = '<!-- STATS_START -->';
	const endMarker = '<!-- STATS_END -->';
	const startIdx = content.indexOf(startMarker);
	const endIdx = content.indexOf(endMarker);
	const newBlock = `${startMarker}\n${buildStatsBlock(counts)}\n${endMarker}`;

	if (startIdx !== -1 && endIdx !== -1 && endIdx > startIdx) {
		const before = content.slice(0, startIdx);
		const after = content.slice(endIdx + endMarker.length);
		content = before + newBlock + after;
	} else {
		// If markers not found, append at end
		content = content + '\n' + newBlock;
	}

	fs.writeFileSync(readmePath, content, 'utf8');
}

// Main
const counts = {};
for (const topic of topics) {
	const dir = path.join(repoRoot, topic);
	counts[topic] = countFilesInDir(dir);
}

updateReadme(counts);
console.log('Updated README stats:', counts);
