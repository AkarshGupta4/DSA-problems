class Solution {
    public String removeStars(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch != '*' ){
                sb.append(ch);
            } else{
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}