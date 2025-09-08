// User function template for Java

class Solution {
    static String delAlternate(String S) {
        // code here
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i< S.length(); i++){
            if(i%2==0){
                sb.append(S.charAt(i));
            }
        }
        
        return sb.toString();
    }
}