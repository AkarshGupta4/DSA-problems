class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int a = prices.length;
        int minvalue =   Integer.MAX_VALUE;
        
        for(int i=0; i<a; i++){
            if(prices[i] < minvalue){
                minvalue = prices[i];
            } else{
                int profit = prices[i] - minvalue;
                if(profit>maxprofit){
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}