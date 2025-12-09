class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum =0;
        int count =0;
        if(nums[0]==1 && nums[1]==1 && n==2) return 1;
        for(int i=0; i<n-1; i++){

            int left =0;
            for(int k=0; k<=i; k++){
               left += nums[k];
            }
            
            int right = 0;
            for(int j=i+1; j<n; j++){
                right += nums[j];
            }

            if((left - right )%2 == 0){
                count++;
            }
        }

        return count;
    }
}