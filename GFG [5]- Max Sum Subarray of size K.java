class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;

        
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];  
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
