1class Solution {
2    public int[] findOrder(int n, int[][] pre) {
3
4        List<List<Integer>> adj = new ArrayList<>();
5        for(int i = 0; i < n; i++)
6            adj.add(new ArrayList<>());
7
8        int[] indegree = new int[n];
9
10        for(int i = 0; i < pre.length; i++){
11            int a = pre[i][0], b = pre[i][1];
12            adj.get(b).add(a);
13            indegree[a]++;
14        }
15
16        Queue<Integer> q = new LinkedList<>();
17        List<Integer> ans = new ArrayList<>();   // ✅ declare ans
18
19        for(int i = 0; i < n; i++){
20            if(indegree[i] == 0){
21                q.add(i);
22            }
23        }
24
25        while(q.size() > 0){
26            int curr = q.poll();
27            ans.add(curr);
28
29            for(int ele : adj.get(curr)){
30                indegree[ele]--;
31                if(indegree[ele] == 0){
32                    q.add(ele);
33                }
34            }
35        }
36
37        // ✅ check cycle
38        if(ans.size() != n)
39            return new int[0];
40
41        // ✅ convert list to array
42        int[] ans2 = new int[n];
43        for(int i = 0; i < n; i++){
44            ans2[i] = ans.get(i);
45        }
46
47        return ans2;
48    }
49}
50