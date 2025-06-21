class Solution {
    public String reverseWords(String s) {
        String array [] = s.trim().split("\\s+");  
        StringBuilder result  = new StringBuilder();
        int n = array.length;
        for(int i = n - 1; i >= 0; i--) {
            result.append(array[i]);
            if(i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}