import java.util.Stack;

class Solution {
    static void reverse(Stack<Integer> st) {
        Stack<Integer> rt = new Stack<>();
        
        while (st.size() > 0) {
            rt.push(st.pop());
        }
        
        Stack<Integer> gt = new Stack<>();
        
        while (rt.size() > 0) {
            gt.push(rt.pop());
        }
        
        while (gt.size() > 0) {
            st.push(gt.pop());
        }
    }
}
