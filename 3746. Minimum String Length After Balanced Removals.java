class Solution {
    public int minLengthAfterRemovals(String s) {
        int counta = 0;
        int countb = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                counta++;
            }
            else{
                countb++;
            }
        }

        return Math.abs(counta - countb);
    }
}