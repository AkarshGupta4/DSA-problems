class Solution {
    // Function to calculate factorial of a number.
    int factorial(int n) {
        // code here
        // Base Case
        
        if(n==0) return 1;
        
        int smallAns = factorial(n-1);
        
        int ans = n*smallAns;
        
        return ans;
    }
    
   
}
