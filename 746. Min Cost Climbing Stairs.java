class Solution {

    public int mincost(int[] cost, int idx, int[] dp){
        if(idx >= cost.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        return dp[idx] = cost[idx] + Math.min(mincost(cost, idx+1,dp) , mincost(cost,idx+2,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(mincost(cost, 0,dp), mincost(cost,1,dp));
    }
}