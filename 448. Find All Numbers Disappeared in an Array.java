class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> table = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!table.contains(nums[i])) {
                table.add(nums[i]);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            if (!table.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}