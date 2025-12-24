class Solution {
    public long minCuttingCost(int n, int m, int k) {
        
        if(n <= k && m <= k){
            return 0;
        }

        if(n>k){
            return (long)(n-k)*k;

        }

        return (long)(m - k) * k;
    }
}