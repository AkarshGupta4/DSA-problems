class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int peakIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[peakIndex]) {
                peakIndex = i;
            }
        }

        return peakIndex;
    }
}
