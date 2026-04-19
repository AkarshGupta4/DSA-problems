1class Solution {
2    public int findCircleNum(int[][] Connected) {
3        int n = Connected.length;
4
5        boolean[] visited = new boolean[n];
6
7        int count = 0;
8
9        for(int i=0; i<n; i++){
10            if(!visited[i]){
11                dfs(i, Connected, visited);
12                count++;
13            }
14        }
15        return count ;       
16    }
17
18    public void dfs(int i , int[][] Connected, boolean[] visited){
19        visited[i] = true;
20
21        for(int j=0; j<Connected.length; j++){
22            if(Connected[i][j] == 1 && !visited[j]){
23               
24                dfs(j, Connected , visited);
25            }
26        }
27    }
28
29    
30}