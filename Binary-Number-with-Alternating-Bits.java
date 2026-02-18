1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        String binary = Integer.toBinaryString(n);
4
5        for(int i = 0; i < binary.length() - 1; i++){
6            if(binary.charAt(i) == binary.charAt(i + 1)) 
7                return false;
8        }
9        return true;
10    }
11}