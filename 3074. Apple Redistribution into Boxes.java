class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        int n = capacity.length;
        int capsum = 0;
        Arrays.sort(capacity);
        int count = 0;

        for(int i=0; i<apple.length; i++){
            sum += apple[i];
        }

        for(int i= n-1; i>=0; i--){
            capsum += capacity[i];
            count ++;
            if(capsum >= sum){
               return count;
            }
        }
        return count;
    }
}