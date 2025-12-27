class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
       if (n < 3) return false;

        int count = -1;
        for(int i=0;i <n-1; i++){
            if (arr[i] < arr[i + 1]) {
                continue;
            } else if(arr[i] > arr[i+1]){
                count = i;
                break;
            } else {
                return false; 
            }

        }
        if (count <= 0 || count == n - 1) return false;
        for(int i = count; i < n - 1; i++){
            if(arr[i]<= arr[i+1]){
                return false;
            }
            
        }

        return true;
    }
}