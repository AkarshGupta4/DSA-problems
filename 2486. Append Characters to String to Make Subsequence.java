class Solution {
    public int appendCharacters(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int j = 0;
        StringBuilder sb = new StringBuilder(s);

        for(int i=0 ; i<n && j<m ; i++){
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }
        }

        sb.append(t.substring(j));
        return m-j;
        
    }
}