class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length-1; i++){
           for (int missing = nums[i] + 1; missing < nums[i + 1]; missing++) {
                ans.add(missing);
            }
        }
        return ans ;
    }
}