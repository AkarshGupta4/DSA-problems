class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int a =0;
        int b =0;
        int c = 0;
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            c = nums[0];
        }

        for(int i=n; i>=0; i--){
            a = nums[n-1];
            b = nums[n-2];
        }

        return a+b-c;


    }
}