
import java.util.*;
class Solution {
    public int findLucky(int[] arr) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        
        for(int num : arr){
            table.put(num, table.getOrDefault(num, 0) + 1); 
        }

        int ans = -1;

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            int freq = table.get(number);

            if (number == freq) {
                ans = Math.max(ans, number);
            }
        }
        return ans;
    }
}