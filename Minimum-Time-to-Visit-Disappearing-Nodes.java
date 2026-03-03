1class Solution {
2    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
3        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
4
5        for(int i = 0; i < n; i++){
6            adj.add(new ArrayList<>());
7        }
8
9        for(int edge[] : edges){
10            int src = edge[0];
11            int dest = edge[1];
12            int len = edge[2];
13
14            adj.get(src).add(new int[]{dest, len});
15            adj.get(dest).add(new int[]{src, len});
16        }
17
18        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
19        pq.offer(new int[]{0, 0});
20
21        int dist[] = new int[n];
22        Arrays.fill(dist, Integer.MAX_VALUE);
23        dist[0] = 0;
24
25        while(!pq.isEmpty()){
26            int[] curr = pq.poll();
27            int currDist = curr[0];
28            int node = curr[1];
29
30            if(currDist > dist[node]) continue;
31
32            for(int[] nei : adj.get(node)){
33                int nextNode = nei[0];
34                int len = nei[1];
35                int newLen = len + currDist;
36
37                if(newLen < dist[nextNode] && newLen < disappear[nextNode]){
38                    dist[nextNode] = newLen;
39                    pq.offer(new int[]{dist[nextNode], nextNode});
40                }
41                
42            }
43
44        }
45        for(int i = 0; i < n; i++){
46            if(dist[i] == Integer.MAX_VALUE){
47                dist[i] = -1;
48            }
49        }
50
51        return dist;
52    }
53}