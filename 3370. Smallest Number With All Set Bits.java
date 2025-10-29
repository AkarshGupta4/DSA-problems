class Solution {
    public int smallestNumber(int n) {
        int x = 1; 
        
       
        while (x - 1 < n) {
            x = x * 2;  
        }

        return x - 1; 
    }
}
