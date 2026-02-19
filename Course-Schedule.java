1import java.util.*;
2
3class Solution {
4    public boolean canFinish(int n, int[][] pre) {
5
6        List<List<Integer>> adj = new ArrayList<>();
7        for(int i = 0; i < n; i++) {
8            adj.add(new ArrayList<>());
9        }
10
11        int[] indegree = new int[n];
12
13        // Build graph
14        for(int i = 0; i < pre.length; i++){
15            int a = pre[i][0];
16            int b = pre[i][1];
17
18            adj.get(b).add(a);
19            indegree[a]++;
20        }
21
22        Queue<Integer> q = new LinkedList<>();
23
24        // Add nodes with indegree 0
25        for(int i = 0; i < n; i++){
26            if(indegree[i] == 0){
27                q.add(i);
28            }
29        }
30
31        int count = 0;
32
33        // Kahn's Algorithm
34        while(!q.isEmpty()){
35            int curr = q.poll();
36            count++;
37
38            for(int next : adj.get(curr)){
39                indegree[next]--;
40                if(indegree[next] == 0){
41                    q.add(next);
42                }
43            }
44        }
45
46        return count == n;
47    }
48}
49