1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        
4        int store[] = new int[n+1];
5        Arrays.fill(store ,Integer.MAX_VALUE);
6        store[k] = 0;
7
8        for(int i=0; i<n-1; i++){
9            for(int edge[] : times){
10                int u = edge[0];
11                int v = edge[1];
12                int w = edge[2];
13
14                if(store[v] > store[u] + w && store[u] != Integer.MAX_VALUE){
15                    store[v] = store[u] + w;
16                }
17            }
18        }
19
20        int max = 0;
21
22        for (int i = 1; i <= n; i++) {
23            if (store[i] == Integer.MAX_VALUE) {
24                return -1;
25            }
26            max = Math.max(max, store[i]);
27        }
28
29        return max;
30    }
31}