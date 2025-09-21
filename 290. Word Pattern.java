import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        HashMap<Character, String> chartoword = new HashMap<>();
        HashMap<String, Character> wordtochar = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            char pat = pattern.charAt(i);
            String w = words[i];

            if(chartoword.containsKey(pat)){
                if(!chartoword.get(pat).equals(w)){
                    return false;
                }
            } else {
                chartoword.put(pat, w);
            }

            if(wordtochar.containsKey(w)){
                if(wordtochar.get(w) != pat){
                    return false;
                }
            } else {
                wordtochar.put(w, pat);
            }
        }

        return true;
    }
}
