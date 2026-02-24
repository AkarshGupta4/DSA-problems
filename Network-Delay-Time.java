1import java.util.*;
2
3class Solution {
4
5    class Pair {
6        int node;
7        int time;
8
9        Pair(int node, int time) {
10            this.node = node;
11            this.time = time;
12        }
13    }
14
15    public int networkDelayTime(int[][] times, int n, int k) {
16
17        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
18        for (int i = 0; i <= n; i++) {
19            adj.add(new ArrayList<>());
20        }
21
22       
23        for (int i = 0; i < times.length; i++) {
24            int u = times[i][0];
25            int v = times[i][1];
26            int w = times[i][2];
27
28            adj.get(u).add(new Pair(v, w));
29        }
30
31        
32        int[] dist = new int[n + 1];
33        Arrays.fill(dist, Integer.MAX_VALUE);
34
35       
36        PriorityQueue<Pair> pq = new PriorityQueue<>(
37            (a, b) -> Integer.compare(a.time, b.time)
38        );
39
40        dist[k] = 0;
41        pq.add(new Pair(k, 0));
42
43        
44        while (!pq.isEmpty()) {
45
46            Pair curr = pq.poll();
47            int node = curr.node;
48            int currTime = curr.time;
49
50            if (currTime > dist[node]) continue;
51
52            for (Pair neighbor : adj.get(node)) {
53
54                int newTime = currTime + neighbor.time;
55
56                if (newTime < dist[neighbor.node]) {
57                    dist[neighbor.node] = newTime;
58                    pq.add(new Pair(neighbor.node, newTime));
59                }
60            }
61        }
62
63        int maxTime = 0;
64
65        for (int i = 1; i <= n; i++) {
66            if (dist[i] == Integer.MAX_VALUE) {
67                return -1;
68            }
69            maxTime = Math.max(maxTime, dist[i]);
70        }
71
72        return maxTime;
73    }
74}