import java.util.Hashtable;

class Solution {
    public int firstUniqChar(String s) {
        Hashtable<Character, Integer> h = new Hashtable<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (h.containsKey(c)) {
                h.put(c, h.get(c) + 1);
            } else {
                h.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (h.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
