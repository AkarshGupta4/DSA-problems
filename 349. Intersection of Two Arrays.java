class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet<>();
        HashSet<Integer> intersection= new HashSet<>();

        for(int n : nums1){
            set.add(n);
        }
        for(int n : nums2){
            if(set.contains(n)){
                intersection.add(n);
            }
        }
        int[] result = new int[intersection.size()];
        int i=0;
        for (int n :intersection) {
            result[i++] = n;
        }
        return result;
    }
}