class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = nums.get(i) > nums.get(i - 1) ? left[i - 1] + 1 : 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums.get(i) < nums.get(i + 1) ? right[i + 1] + 1 : 1;
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, Math.min(left[i], right[i + 1]));
        }

        return ans;
    }
}
