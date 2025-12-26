class Solution {
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i = 0; i<n; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count == 1){
                sum += nums[i];
            }
        }
        return sum;
    }
}