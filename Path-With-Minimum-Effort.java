1class Solution {
2    public int minimumEffortPath(int[][] heights) {
3        int n = heights.length;
4        int m = heights[0].length;
5
6        // effort array to store 
7
8        int[][] effort = new int[n][m];
9
10        for(int row[] : effort){
11            Arrays.fill(row,Integer.MAX_VALUE);
12        }
13        effort[0][0] = 0;
14
15        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)  -> a[0] - b[0]);
16
17        pq.add(new int[]{0,0,0}) ; // {effort, row, col}
18
19        int[] rd = {1,-1,0,0};
20        int[] cl = {0,0,1,-1};
21
22        while(!pq.isEmpty()){
23            int[] curr = pq.poll();
24            int currEffort = curr[0];
25            int r = curr[1];
26            int c = curr[2];
27
28            if (r == n - 1 && c == m - 1) {
29                return currEffort;
30            }
31
32            for(int i=0; i<4; i++){
33                int nr = r + rd[i];
34                int nc = c + cl[i];
35
36                if(nc>=0 && nr>=0 && nr<n && nc<m){
37                    int weight = Math.abs(heights[r][c] - heights[nr][nc]);
38
39                    int newEffort = Math.max(currEffort, weight);
40                    if(newEffort < effort[nr][nc]){
41                        effort[nr][nc] = newEffort;
42                        pq.add(new int[] {newEffort , nr , nc});
43                    }
44                }
45
46            }
47        }
48        return 0;
49    }
50}