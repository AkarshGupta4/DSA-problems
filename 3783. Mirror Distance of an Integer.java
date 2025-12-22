class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        for(int i=n; i>0 ;i = i/10){
            rev = rev * 10 + (i % 10);
        }

        return Math.abs(n - rev);
    }
}