class Solution {
    public int maximumDifference(int[] nums) {

        int diffrence = -1;        
        
        int n = nums.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i] < nums[j]){
                    int diff = nums[j] - nums[i];
                 
                    if(diff > diffrence){
                         diffrence = diff;
                    }
                }
            }
        }
        return diffrence;
        
    }
}