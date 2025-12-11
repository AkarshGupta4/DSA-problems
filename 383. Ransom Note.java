import java.util.Hashtable;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Hashtable<Character , Integer> ht = new Hashtable<>();


        for(int i=0 ; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            ht.put(c , ht.getOrDefault(c,0) + 1);
        }

        for(int j = 0 ; j<ransomNote.length(); j++){
            char c = ransomNote.charAt(j);
            if(!ht.containsKey(c) || ht.get(c) == 0){
                return false;
            }
            ht.put(c, ht.get(c) - 1);
        }
        return true;
    }
}