class Solution {
    public int minimumFlips(int n) {
         String s = Integer.toBinaryString(n);
        int i =0;
        int j = s.length()-1;
        int flip = 0;

        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                flip++;
            }
            
                i++;
                j--;
        }

        return flip*2;
    }
}