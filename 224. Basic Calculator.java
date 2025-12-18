class Solution {
    public int calculate(String s) {
        int n = s.length();
        int sign = 1;
        int result  = 0;
        int num = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 +(c-'0');

            }
            else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            } else if(c == '-'){
                result += sign*num;
                num = 0;
                sign = -1;
            } else if(c== '('){
                st.push(result);
                st.push(sign);
                sign = 1;
                result = 0;
            } else if(c == ')'){
                result += sign * num;
                num = 0;
                result *= st.pop(); 
                result += st.pop(); 
            }
        }

        result += sign*num;
        return result;

    }
}