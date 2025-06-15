class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int posnums[] = new int[n];
        int negnums[] = new int[n];
        int posIndex = 0;
        int negIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                posnums[posIndex++] = nums[i];

            } else {
                negnums[negIndex++] = nums[i];
            }
        }

        int[] result = new int[n];
        int i = 0, p = 0, q = 0;

        while (i < n) {
            result[i++] = posnums[p++];
            result[i++] = negnums[q++];
        }

        return result;

    }
}