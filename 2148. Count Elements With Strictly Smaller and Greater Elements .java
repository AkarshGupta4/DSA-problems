class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int count = 0;

        int min = nums[0];
        int max = nums[n-1];
        
        for(int i=1; i<n-1; i++){
            if(nums[i] > min && nums[i] < max){
                count++;
            }
        }

        return count;
    }
}