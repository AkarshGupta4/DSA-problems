import java.util.*;
class Solution {
    public int repeatedNTimes(int[] nums) {
        Hashtable<Integer, Integer> table  = new Hashtable<>();

        for(int n : nums){
            if(table.containsKey(n)){
                return n;
            } else{
                table.put(n,1);
            }
        }    
        return -1;
    }
}