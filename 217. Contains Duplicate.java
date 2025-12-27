import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Hashtable<Integer, Integer> table = new Hashtable<>();

        for(int num : nums){
            table.put(num, table.getOrDefault(num, 0) + 1); 
        }

        for (int key : table.keySet()) {
            if (table.get(key) > 1) {
                return true;   
            }
        }
        return false;
    }
}