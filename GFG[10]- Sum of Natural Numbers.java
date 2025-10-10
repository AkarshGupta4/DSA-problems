class Solution {
    public static int findSum(int n) {
        // code here
        if(n==0) return 0;
        
        return findSum(n-1)+n;
    }
}
