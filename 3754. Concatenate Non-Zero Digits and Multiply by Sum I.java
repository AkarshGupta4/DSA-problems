class Solution {
    public long sumAndMultiply(int n) {
        
        String s = Integer.toString(n);

        StringBuilder sb = new StringBuilder();

        int sum =0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '0'){
                sb.append(ch);
                sum += ch -'0';
            }
        }

        long x;

        if(sb.length() > 0){
            x = Long.parseLong(sb.toString());
        }
        else{
            x=0;
        }

        return x * sum;
    
    }
}