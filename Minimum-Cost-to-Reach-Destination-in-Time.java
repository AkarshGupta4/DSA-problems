1class Solution {
2
3    class Pair{
4        int node ;
5        int cost;
6        int time;
7
8        Pair(int node , int cost, int time){
9            this.node = node;
10            this.cost = cost;
11            this.time = time;
12
13        }
14    }
15    public int minCost(int maxTime, int[][] edges, int[] passingfees) {
16        int n = passingfees.length;
17
18        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
19
20        for(int i=0; i<n; i++){
21             adj.add(new ArrayList<>());
22        }
23
24        for(int[] edge : edges){
25            int u = edge[0];
26            int v = edge[1];
27            int t = edge[2];
28
29            adj.get(u).add(new Pair(v,0,t));
30            adj.get(v).add(new Pair(u,0,t));
31        }
32
33
34        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
35
36        int[] mintime = new int[n];
37        Arrays.fill(mintime , Integer.MAX_VALUE);
38        mintime[0] = 0;
39        pq.offer(new Pair(0, passingfees[0], 0));
40        while(!pq.isEmpty()){
41            Pair curr = pq.poll();
42
43            int node = curr.node;
44            int cost = curr.cost;
45            int time = curr.time;
46
47            if( node == n-1){
48                return cost;
49            }
50
51            for(Pair neig : adj.get(node)){
52                int newtime = time + neig.time;
53                int newcost = cost + passingfees[neig.node];
54                if (newtime <= maxTime && newtime < mintime[neig.node]) {
55                    mintime[neig.node] = newtime;
56                    pq.offer(new Pair(neig.node, newcost, newtime));
57                }
58            }
59        }
60
61        return -1;
62    }
63}