class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;

        HashSet<Integer> map = new HashSet<>();

        for(int i=0; i<n; i++){
            if( nums[i]%k == 0){
                map.add(nums[i] );
            }
        }

        for(int i=1; i<n+5; i++){
            int multiples = i*k;
            if(!map.contains(multiples)){
                return multiples;
            } else{
                continue;
            }
        }
        return -1;
    }
}