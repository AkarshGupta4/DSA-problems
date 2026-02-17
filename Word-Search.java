1class Solution {
2
3    int[] rowDirection = {1,-1,0,0};
4    int[] colDirection = {0,0,1,-1};
5
6    public boolean exist(char[][] board, String word) {
7        int n = board.length;
8        int m = board[0].length;
9        boolean[][] isvisited = new boolean[n][m];
10
11        for(int i=0; i<n; i++){
12            for(int j=0; j<m; j++){
13                if(board[i][j] == word.charAt(0)){
14                    if(dfs(board , word , i , j , 0 , isvisited))
15                        return true;
16                }
17            }
18        }
19        return false;
20    }
21
22    public boolean dfs(char[][] board , String word , int row , int col, int index , boolean[][] isvisited){
23        if (index == word.length()) {
24            return true;
25        }
26        
27        if(row<0 || col<0 || row>= board.length || col>= board[0].length || isvisited[row][col] || board[row][col] != word.charAt(index)) return false;
28
29        isvisited[row][col] = true;
30
31        for(int i=0; i<4; i++){
32            int newRow = row + rowDirection[i];
33            int newCol = col + colDirection[i];
34
35            if(dfs(board , word, newRow , newCol, index+1 , isvisited)) return true;
36        }
37
38        isvisited[row][col] = false;
39        return false;
40    }
41}