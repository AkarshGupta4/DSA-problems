1class Solution {
2    public String trimTrailingVowels(String s) {
3       
4        return s.replaceAll("[aeiou]+$", "");
5
6    }
7}