class Solution {
    public int absDifference(int[] nums, int k) {
        
        Arrays.sort(nums);

        int smallsum = 0;
        int largesum = 0;

        for(int i=0; i<k; i++){
            smallsum += nums[i];
        }

        for(int i=nums.length-1; i>= nums.length - k ; i--){
            largesum += nums[i];
        }

        return Math.abs(largesum - smallsum);
    }
}