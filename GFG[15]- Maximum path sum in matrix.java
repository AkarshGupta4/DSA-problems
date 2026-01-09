// User function Template for Java
class Solution {
    static int [][] dp;
    public int path(int [][] arr, int r, int c){
        int n = arr.length, m = arr[0].length;
        
        if(r>=n || c<0 || c>=m) return Integer.MIN_VALUE; 
        if(r==n-1) return arr[r][c];
        if(dp[r][c] != 0) return dp[r][c];
        
        int left = path(arr, r+1, c-1);
        int right = path(arr, r+1, c+1);
        int down = path(arr, r+1,c);
        
        return dp[r][c] = arr[r][c] + Math.max(left,Math.max(down,right));
    }
    public int maximumPath(int[][] arr) {
        // code here
        int n = arr.length, m = arr[0].length;
        
        dp = new int[n][m]; // by default all values are zero to ham dp ko -1 se initialize ya fill nhi karenge!!!!! 
        
        int ans = -1;
        // first row ke koi bhi element se start kar sakte hai 
        for(int j =0; j<m; j++){
            ans = Math.max(ans,path(arr,0,j));
        }
        return ans;
    }
}