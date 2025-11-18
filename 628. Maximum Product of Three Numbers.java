class Solution{
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        int ans = nums[n-1] * nums[n-2] * nums[n-3];
        int ans2 = nums[0] * nums[1] * nums[n-1];

        return (ans>ans2) ? ans : ans2;
    
    }
}