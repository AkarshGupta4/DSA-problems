
import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Hashtable<Integer ,Integer> freq = new Hashtable<>();

        for(int nums : arr){
            freq.put(nums, freq.getOrDefault(nums, 0) + 1);
        }

        ArrayList<Integer> values = new ArrayList<>(freq.values());

        for(int i=0 ; i<values.size(); i++){
            for(int j = i+1; j<values.size(); j++){
                if (values.get(i).equals(values.get(j))) {
                    return false; 
                }
            }
        
        }       
        
        return true;
    }
}