class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sCH = s.charAt(i);
            map.put(sCH , map.getOrDefault(sCH,0)+1);
            
        }

        for(int i=0; i<t.length(); i++){
           
            char tCH = t.charAt(i);

            if(!map.containsKey(tCH) || map.get(tCH) == 0 ){
                return tCH;
            }
            else{
                map.put(tCH, map.get(tCH) - 1);
            }
        }
        return 0;
    }
}