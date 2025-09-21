class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character , Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char Schar = s.charAt(i);
            char tchar = t.charAt(i);

            if(map.containsKey(Schar)){
                if(map.get(Schar) != tchar){
                    return false;
                }
            }  else{
                    if(map.containsValue(tchar)){
                        return false;
                    }

                    map.put(Schar , tchar);
            }

        }
        return true;
    }
}