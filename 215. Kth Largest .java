
import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}




class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            result.add(nums[i]);
        }
         return result.get(k - 1);
    }
}