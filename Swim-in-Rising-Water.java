1class Solution {
2
3    class Pair{
4        int row;
5        int col;
6        int time;
7
8        Pair(int row, int col , int time){
9            this.row = row;
10            this.col = col;
11            this.time= time;
12
13        }
14    }
15
16    int[] rowDirection = {1,-1,0,0};
17    int[] colDirection = {0,0,1,-1};
18
19    public int swimInWater(int[][] grid) {
20        int n = grid.length;
21        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
22        boolean[][] isvisited = new boolean[n][n];
23
24        pq.offer(new Pair(0, 0, grid[0][0]));
25
26        while(!pq.isEmpty()){
27            Pair curr = pq.poll();
28
29            int r = curr.row;
30            int c = curr.col;
31            int time  = curr.time;
32
33            if(isvisited[r][c]) continue;
34            isvisited[r][c] = true;
35            if (r == n - 1 && c == n - 1) {
36                return time;
37            }
38
39            for(int i=0; i<4; i++){
40                int nr = r + rowDirection[i];
41                int nc = c + colDirection[i];
42
43                if(nr>=0 && nc>=0 && nr<n && nc < n && !isvisited[nr][nc]){
44                    int newtime = Math.max(time , grid[nr][nc]);
45                    pq.add(new Pair(nr , nc , newtime));
46                }
47            }
48        }
49        return -1;
50        
51    }
52}