import json
import os
from datetime import datetime

class ProblemTracker:
    def __init__(self):
        self.data_file = 'problem_data.json'
        self.load_data()

    def load_data(self):
        if os.path.exists(self.data_file):
            with open(self.data_file, 'r') as f:
                self.data = json.load(f)
        else:
            self.data = {
                'topics': {},
                'difficulty_count': {'Easy': 0, 'Medium': 0, 'Hard': 0},
                'total_solved': 0
            }

    def add_problem(self, name, topic, difficulty, file_path):
        if topic not in self.data['topics']:
            self.data['topics'][topic] = {
                'solved': 0,
                'problems': []
            }
        
        self.data['topics'][topic]['solved'] += 1
        self.data['topics'][topic]['problems'].append({
            'name': name,
            'difficulty': difficulty,
            'file_path': file_path,
            'date_added': datetime.now().strftime('%Y-%m-%d')
        })
        
        self.data['difficulty_count'][difficulty] += 1
        self.data['total_solved'] += 1
        self.save_data()
        self.update_readme()

    def save_data(self):
        with open(self.data_file, 'w') as f:
            json.dump(self.data, f, indent=4)

    def update_readme(self):
        readme_template = self.get_readme_template()
        
        # Update topic table
        topic_rows = []
        for topic, info in self.data['topics'].items():
            mastery = '⭐' * (info['solved'] // 5 + 1)
            topic_rows.append(f"| {topic} | {info['solved']} | {mastery} |")
        
        # Update mermaid chart data
        mermaid_data = [
            f'"Easy" : {self.data["difficulty_count"]["Easy"]}',
            f'"Medium" : {self.data["difficulty_count"]["Medium"]}',
            f'"Hard" : {self.data["difficulty_count"]["Hard"]}'
        ]

        # Create the final README content
        readme_content = readme_template.replace(
            '{{TOPIC_ROWS}}', '\n'.join(topic_rows)
        ).replace(
            '{{MERMAID_DATA}}', ',\n    '.join(mermaid_data)
        )

        with open('README.md', 'w') as f:
            f.write(readme_content)

    def get_readme_template(self):
        return '''# Data Structures and Algorithms Practice

## 📚 Problem Categories
...your existing categories...

## 🎯 Progress Tracking

```mermaid
pie title Problem Solving Progress
    {{MERMAID_DATA}}
```

## 📊 Topic Coverage

| Topic | Problems Solved | Mastery Level |
|-------|----------------|---------------|
{{TOPIC_ROWS}}

...rest of your README content...
'''

# Usage example
if __name__ == "__main__":
    tracker = ProblemTracker()
    # Example: tracker.add_problem("Two Sum", "Arrays", "Easy", "./Arrays/two-sum.js")
