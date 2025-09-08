class Solution {
    static String revStr(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            stack.push(s.charAt(i));
        }
        
        StringBuilder storestr = new StringBuilder();
        
        // isme check set karna hia jo check kkarega ki stack khali hua ki nhi 
        while(!stack.isEmpty()){
            storestr.append(stack.pop()); 
        }
        
        return storestr.toString();
    }
}