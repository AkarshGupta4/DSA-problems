1class Solution {
2    public int minPathSum(int[][]arr) {
3        int m = arr.length;
4        int n = arr[0].length;
5
6        int [][]dp = new int[m][n];
7        for(int i=0; i<m; i++){
8            for(int j=0; j<n; j++){
9                if(i==0 && j==0) dp[i][j] = arr[i][j];
10                else if(i==0) dp[i][j] = arr[i][j] + dp[i][j-1];
11                else if(j==0) dp[i][j] = arr[i][j] + dp[i-1][j];
12                else dp[i][j] = arr[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
13            }
14        }
15
16        return dp[m-1][n-1];
17    }
18}