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
        
        # Update Mermaid chart data with proper syntax
        mermaid_data = '\n    '.join([
            f'"{difficulty}" : {count}'
            for difficulty, count in self.data['difficulty_count'].items()
        ])
        
        # Create topic progress data
        topic_progress = '\n    '.join([
            f'{topic}["{topic}"] --> {topic}Count["{info["solved"]} Problems"]'
            for topic, info in self.data['topics'].items()
        ])

        readme_content = readme_template.replace(
            '{{MERMAID_PIE_DATA}}', mermaid_data
        ).replace(
            '{{MERMAID_TOPIC_DATA}}', topic_progress
        )

        with open('README.md', 'w') as f:
            f.write(readme_content)

    def get_readme_template(self):
        return '''# Data Structures and Algorithms Practice
        
## 🎯 Progress Tracking

```mermaid
%%{init: {'theme':'default'}}%%
pie showData
    title Problems by Difficulty
    {{MERMAID_PIE_DATA}}
```

## 📈 Topic-wise Progress

```mermaid
%%{init: {'theme':'default'}}%%
graph LR
    subgraph Progress
    {{MERMAID_TOPIC_DATA}}
    end
```

<!-- Rest of the template -->
'''

# Usage example
if __name__ == "__main__":
    tracker = ProblemTracker()
    # Example: tracker.add_problem("Two Sum", "Arrays", "Easy", "./Arrays/two-sum.js")
