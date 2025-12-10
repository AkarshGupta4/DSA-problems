class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // isme ham dekh rhe hai ki jo last element hai wo repeated hai ya nhi 
        if (nums[n - 1] != n - 1) return false;

        for(int i=0; i<n-1; i++){
            
            if(nums[i] != i+1) return false;
         }

         return true;
    }
}