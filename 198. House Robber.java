class Solution {


    // dp method
    
    public int maxloot(int[] nums, int idx , int[] dp){
    
        if(idx >=nums.length) return 0;
        if (dp[idx] != -1) return dp[idx];
        int steel = nums[idx] + maxloot(nums, idx+2, dp);
        int skip = maxloot(nums, idx+1 , dp);
        return dp[idx] = Math.max(steel , skip);

    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return maxloot(nums, 0,dp); 
    }


    // // recursive method
    // public int maxloot(int[] nums, int idx){
    
    //     if(idx >=nums.length) return 0;
    //     int steel = nums[idx] + maxloot(nums, idx+2);
    //     int skip = maxloot(nums, idx+1);
    //     return Math.max(steel , skip);

    // }
    // public int rob(int[] nums) {
    //     return maxloot(nums, 0); 
    // }
}