class Solution {
    int[][] dp;

    public int path(int m, int n){
        if(m==1 && n==1) return 1;
        if(m==0 || n==0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        
        int rightways = path(m,n-1);
        int downways = path(m-1,n);
        
        return dp[m][n] = rightways + downways;
        
    }
    public int uniquePaths(int m, int n) {
        // Code Here
         dp = new int[m+1][n+1];
        for(int i=0 ; i<=m; i++){
            for(int j=0; j<=n; j++){
                dp[i][j] = -1;
            }
        }
        return path(m,n);
    }
}