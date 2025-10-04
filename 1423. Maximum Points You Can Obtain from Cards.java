class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum =0 , rsum = 0, maxsum = 0;

        for(int i=0; i<k; i++){
            lsum = lsum + cardPoints[i];
            
        }
        maxsum = lsum;

        int rIndex = n-1;

        for(int i=k-1; i>=0 ; i--){
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rIndex];
            rIndex--;
            maxsum = Math.max(maxsum , lsum + rsum);
        }

        return maxsum;
    }
}