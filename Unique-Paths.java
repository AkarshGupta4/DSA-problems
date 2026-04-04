1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[][] dp = new int[2][n];
4
5        // initialize first row
6        for(int j = 0; j < n; j++){
7            dp[0][j] = 1;
8            dp[1][j] = 1;
9        }
10
11        for(int i = 1; i < m; i++){  
12            for(int j = 1; j < n; j++){
13                dp[1][j] = dp[1][j-1] + dp[0][j];
14            }
15
16            // copy current row to previous
17            for(int j = 0; j < n; j++){
18                dp[0][j] = dp[1][j];
19            }
20        }
21
22        return dp[1][n-1];
23    }
24}