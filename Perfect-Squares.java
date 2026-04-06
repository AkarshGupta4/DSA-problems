1import java.util.*;
2
3class Solution {
4
5    public boolean isperfect(int n){
6        int sqrt = (int) Math.sqrt(n);
7        return (sqrt * sqrt == n);
8    }
9    
10    public int minSquare(int n, int[] dp){
11        if(n == 0) return 0;                  
12        
13        if(isperfect(n)) return 1;
14
15        if(dp[n] != -1) return dp[n];         
16        
17        int min = Integer.MAX_VALUE;
18
19        for(int i = 1; i * i <= n; i++){
20            int count = 1 + minSquare(n - i*i, dp);   
21            min = Math.min(min, count);  
22        }
23
24        return dp[n] = min;
25    }
26
27    public int numSquares(int n) {
28        int[] dp = new int[n + 1];
29        Arrays.fill(dp, -1);
30        return minSquare(n, dp);
31    }
32}