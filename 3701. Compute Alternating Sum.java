class Solution {
    public int alternatingSum(int[] nums) {
        int n = nums.length;

        int sum =0; 
        int sign =1;

        for(int i=0; i<n; i++){
            if(sign == 1){
                sum += nums[i];
                sign = sign*-1;
            } else{
                sum -= nums[i];
                sign = sign * -1;
            }
        }
        return sum;
    }
}