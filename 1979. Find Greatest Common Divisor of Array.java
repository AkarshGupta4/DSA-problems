class Solution {
    public int findGCD(int[] nums) {
         Arrays.sort(nums);
        int x = nums[0];
        int y = nums[nums.length - 1];
        return gcd(y, x);
    }

    static int gcd(int x , int y){
        if(y == 0) {
            return x;
        }

        return gcd(y , x%y);
    }
}