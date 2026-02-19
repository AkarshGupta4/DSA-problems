1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3        int n = graph.length;
4        int[] indegree= new int[n];
5
6        List<List<Integer>> adj = new ArrayList<>();
7        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
8
9        for(int i=0; i<n; i++){
10            for(int ele : graph[i]){
11                adj.get(ele).add(i);
12                indegree[i]++;
13            }
14        }
15
16        Queue<Integer> q= new LinkedList<>();
17        List<Integer>ans = new ArrayList<>();
18
19        for(int i=0; i<n; i++){
20            if(indegree[i] == 0) q.add(i);
21        }
22        while(q.size()>0){
23            int curr = q.poll();
24            ans.add(curr);
25
26            for(int ele : adj.get(curr)){
27                indegree[ele]--;;
28                if(indegree[ele] == 0) q.add(ele);
29            }
30        }
31        Collections.sort(ans);
32        return ans;
33    }
34}