class Solution {
    public String replaceDigits(String s) {
        int  n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(i%2==0){
                sb.append(s.charAt(i));
            }else {
                char prev = s.charAt(i - 1);
                int shift = s.charAt(i) - '0';
                sb.append((char)(prev + shift));
            }
        }
        return sb.toString();
        

    }
}