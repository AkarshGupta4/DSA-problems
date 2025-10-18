class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> table = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if (table.contains(nums[i])) {
                result.add(nums[i]);
            } else {
                table.add(nums[i]);
            }
        }
        return result;
    }
}