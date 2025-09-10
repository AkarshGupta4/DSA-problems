
// // ye method dab me kaam nhi karega abhi kabhi fail ho jayega 

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
//         int n = nums.length;

//         for(int i=0; i<n-1; i++){
//             for(int j=0; j<n-i-1; j++){
//                 if(nums[j] > nums[j+1]){
//                     int temp = nums[j];
//                     nums[j] = nums[j+1];
//                     nums[j+1] = temp;
//                 }
//             }
//         }

//         int longest = 1;
//         int count = 1;

//         for(int i=1; i<n; i++){
//            if (nums[i] == nums[i - 1]) {
//                 continue; 
//             }
//             if(nums[i] == nums[i-1] + 1){
//                 count++;
//             } else{
//                 longest = Math.max(longest , count);
//                 count = 1;
//             }
//         }

//         longest = Math.max(longest ,count);
//         return longest;
//     }
// }


// iss methode se sab ho jayega


class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        Arrays.sort(nums);

        int longest = 1;
        int count = 1;

        for(int i=1; i<n; i++){
           if (nums[i] == nums[i - 1]) {
                continue; 
            }
            if(nums[i] == nums[i-1] + 1){
                count++;
            } else{
                longest = Math.max(longest , count);
                count = 1;
            }
        }

        longest = Math.max(longest ,count);
        return longest;
    }
}