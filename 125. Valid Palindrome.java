class Solution {
    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // yaad rakhne wali baat

        int Start = 0;
        int end = s.length()-1;

        while(Start < end){
            if(s.charAt(Start) != s.charAt(end)){
                return false;
            }
            Start++;
            end--;
        }

        return true;
    }
}