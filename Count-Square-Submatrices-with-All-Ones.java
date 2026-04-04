1class Solution {
2    public int countSquares(int[][] mat) {
3        int n = mat.length;
4        int m = mat[0].length;
5        int count = 0;
6
7        for(int i = 0; i < n; i++){
8            for(int j = 0; j < m; j++){
9
10                if(mat[i][j] == 1){
11                    
12                    if(i > 0 && j > 0){
13                        mat[i][j] = 1 + min(
14                            mat[i-1][j],
15                            mat[i][j-1],
16                            mat[i-1][j-1]
17                        );
18                    }
19
20                    count += mat[i][j];
21                }
22            }
23        }
24
25        return count;
26    }
27
28    private int min(int a, int b, int c){
29        return Math.min(a, Math.min(b, c));
30    }
31}