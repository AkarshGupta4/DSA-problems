const fs = require('fs');
const path = require('path');

const repoRoot = path.resolve(__dirname, '..');
const readmePath = path.join(repoRoot, 'README.md');
const outDir = path.join(repoRoot, 'charts');
const outSvg = path.join(outDir, 'topic_counts.svg');

// Topics to track — adjust to match your folders
const topics = ['Arrays', 'Trees', 'DP', 'LinkedList'];

function countFilesInDir(dirPath) {
	// count regular files only, skip README.md and hidden files
	if (!fs.existsSync(dirPath)) return 0;
	return fs.readdirSync(dirPath, { withFileTypes: true })
		.filter(d => d.isFile() && d.name.toLowerCase() !== 'readme.md' && !d.name.startsWith('.'))
		.length;
}

function makeAsciiBar(count) {
	return '█'.repeat(Math.min(count, 60));
}

function buildSvg(counts) {
	// Simple horizontal bar SVG
	const padding = 20;
	const barHeight = 20;
	const gap = 12;
	const labelWidth = 120;
	const maxBarWidth = 520;
	const maxCount = Math.max(...Object.values(counts), 1);
	const scale = maxBarWidth / maxCount;
	const width = labelWidth + maxBarWidth + padding * 2;
	const height = padding * 2 + Object.keys(counts).length * (barHeight + gap);

	let svg = [];
	svg.push(`<svg xmlns="http://www.w3.org/2000/svg" width="${width}" height="${height}" viewBox="0 0 ${width} ${height}">`);
	svg.push(`<style>
		text { font-family: Arial, Helvetica, sans-serif; font-size:12px; fill:#222; }
		.bar { fill:#2b90d9; }
		.bg { fill:#e6eef8; }
		</style>`);

	let y = padding;
	for (const [i, t] of Object.keys(counts).entries ? Object.keys(counts).entries() : Object.keys(counts).map((k,i)=>[i,k])) {
		// compatibility for older node: ensure we have index and key
	}
	// Iterate predictable order
	let idx = 0;
	for (const t of Object.keys(counts)) {
		const cnt = counts[t];
		const barW = Math.round(cnt * scale);
		const labelX = padding;
		const barX = padding + labelWidth;
		const yPos = padding + idx * (barHeight + gap);

		// label
		svg.push(`<text x="${labelX}" y="${yPos + barHeight - 6}">${escapeXml(t)}</text>`);
		// background bar
		svg.push(`<rect x="${barX}" y="${yPos}" width="${maxBarWidth}" height="${barHeight}" class="bg" rx="4" />`);
		// value bar
		svg.push(`<rect x="${barX}" y="${yPos}" width="${barW}" height="${barHeight}" class="bar" rx="4" />`);
		// value text
		svg.push(`<text x="${barX + barW + 8}" y="${yPos + barHeight - 6}">${cnt}</text>`);

		idx++;
	}

	svg.push(`</svg>`);
	return svg.join('\n');
}

function escapeXml(str) {
	return String(str).replace(/[&<>"']/g, s => ({'&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;',"'":'&apos;'}[s]));
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
	lines.push('```');
	lines.push('\nRendered SVG chart (auto-generated)');
	lines.push('![Topic Growth Chart](./charts/topic_counts.svg)');
	lines.push('\nNote: This section is maintained automatically by .github/workflows/update-readme.yml using scripts/update_stats.js — do not edit manually.');
	return lines.join('\n');
}

function updateReadme(counts) {
	let content = fs.readFileSync(readmePath, 'utf8');

	// Update the Topic Coverage table numeric column for each topic
	for (const t of Object.keys(counts)) {
		const re = new RegExp(`(^\\|\\s*${escapeRegex(t)}\\s*\\|\\s*)\\d+`, 'mi');
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

function escapeRegex(s) {
	return s.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
}

// Main
(function main(){
	const counts = {};
	for (const topic of topics) {
		const dir = path.join(repoRoot, topic);
		counts[topic] = countFilesInDir(dir);
	}

	// ensure output dir
	if (!fs.existsSync(outDir)) fs.mkdirSync(outDir, { recursive: true });

	// write svg
	const svg = buildSvg(counts);
	fs.writeFileSync(outSvg, svg, 'utf8');

	// update README
	updateReadme(counts);

	console.log('Updated README and SVG:', counts);
})();
