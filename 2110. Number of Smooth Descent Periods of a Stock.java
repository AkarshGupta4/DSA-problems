class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 1;
        long  ans = 1; // day one par itna hai 

        for(int i=1; i<prices.length; i++){
            if(prices[i-1] - prices[i] == 1){
                count++;
            } else{
                count = 1;
            }
            ans +=count ;
        }

        return ans;
    }
}