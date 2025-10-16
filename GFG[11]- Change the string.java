// User function Template for Java

class Solution {
    String modify(String s) {
         if (s.length() == 0) return s;
        
        if (Character.isUpperCase(s.charAt(0))) {
            return s.toUpperCase(); 
        }
        else return s.toLowerCase();
    }
}