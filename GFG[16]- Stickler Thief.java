class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0] , arr[1]);
        for(int i=2 ; i<n; i++){
            dp[i] = Math.max(arr[i]+ dp[i-2], dp[i-1]);
        }
            return Math.max(dp[n-2] , dp[n-1]);
    }
}