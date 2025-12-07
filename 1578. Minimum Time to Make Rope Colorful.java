class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int totalCost = 0;
        int prev = 0;

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(prev)) {
                totalCost += Math.min(neededTime[i], neededTime[prev]);
                if (neededTime[i] > neededTime[prev]) {
                    prev = i;
                }
            } else {
                prev = i;
            }
        }

        return totalCost;
    }
}
