
import java.util.*;
class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> map1 =new HashMap<>();
        HashMap<String,Integer> map2 =new HashMap<>();

        for(String w1 : words1){
            map1.put(w1,map1.getOrDefault(w1, 0) + 1);
        }
        for(String w2 : words2){
            map2.put(w2,map2.getOrDefault(w2, 0) + 1);
        }

        int count=0;
        for(String key : map1.keySet()){
            if(map1.get(key) == 1 && map2.getOrDefault(key,0) == 1){
                count++;
            }
        }
        return count;

    }
}