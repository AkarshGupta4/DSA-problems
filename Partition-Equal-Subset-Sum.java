1class Solution {
2
3    int[][] dp;
4    public boolean canPartition(int[] nums) {
5
6        int n = nums.length;
7        int target = 0;
8
9        int sum =0;
10
11        for(int i=0; i<nums.length; i++){
12            sum += nums[i];
13        }
14
15        if(sum % 2 == 0){
16           target = sum/2;
17           dp  = new int[n+1][target+1];
18            for (int i = 0; i < n; i++) {
19                Arrays.fill(dp[i], -1);
20            }
21            return subset(nums, target , 0);
22        } else{
23            return false;
24
25        }
26    }
27
28    public boolean subset(int nums[], int target, int i ){
29        if(target == 0) return true;
30        if(i == nums.length) return false;
31
32        boolean take = false;
33
34        if(dp[i][target] != -1){
35            return dp[i][target] == 1;
36        }
37
38        if(nums[i] <= target){
39            take = subset(nums, target - nums[i], i+1);
40        }
41        boolean notTake = subset(nums, target, i+1);
42        dp[i][target] = (take || notTake) ? 1 : 0;
43         return take || notTake;
44    }
45}