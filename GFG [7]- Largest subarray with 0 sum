class Solution {
    int maxLength(int arr[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxlen = 0, prefsum =0;
        map.put(0,-1);
        for(int i=0; i<arr.length; i++){
            prefsum += arr[i];
            
            if(map.containsKey(prefsum)){
                maxlen = Math.max(maxlen , i-map.get(prefsum));
                
            } else{
                map.put(prefsum , i);
            }
        }
        return maxlen;
    }
}