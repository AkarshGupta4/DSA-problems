class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;

        int i=0; 
        while(Math.pow(3,i) <= n){
            if(Math.pow(3,i) == n) return true;
            i++;
        }
        return false;
    }
}