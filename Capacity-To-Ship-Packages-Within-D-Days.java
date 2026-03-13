1class Solution {
2
3    public boolean ispossible(int weight[] , int days, int cap){
4        int reqDays = 1;
5        int totalweight = 0;
6
7        for(int i=0; i<weight.length; i++){
8            int currweight = weight[i];
9            if(currweight + totalweight > cap){
10                reqDays++;
11                totalweight= currweight;
12            }   
13            else totalweight += currweight;
14        }
15        return reqDays <= days;
16
17    }
18
19
20    public int shipWithinDays(int[] weights, int days) {
21        int low = 0;
22        int high = 0;
23
24        for(int w : weights){
25            low = Math.max(low , w);
26            high += w;
27        }
28
29        int ans = high;
30
31        while(low <= high){
32            int mid = (low + high) / 2;
33
34            if(ispossible(weights , days , mid)){
35                ans = mid;
36                high = mid - 1;
37            }else{
38                low = mid + 1;
39            }
40        }
41        return ans;
42    }
43}