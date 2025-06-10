class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)
