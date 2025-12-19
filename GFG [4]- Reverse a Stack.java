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


// import java.util.*;

// public class practice {

//     // Insert element at the bottom of stack
//     public static void insertAtBottom(Stack<Integer> st, int x) {
//         if (st.isEmpty()) {
//             st.push(x);
//             return;
//         }

//         int top = st.pop();
//         insertAtBottom(st, x);
//         st.push(top);
//     }

//     // Reverse stack using recursion
//     public static void reverse(Stack<Integer> st) {
//         if (st.isEmpty()) {
//             return;
//         }

//         int top = st.pop();
//         reverse(st);
//         insertAtBottom(st, top);
//     }

//     public static void main(String[] args) {
//         Stack<Integer> st = new Stack<>();

//         st.push(1);
//         st.push(2);
//         st.push(3);
//         st.push(4);
//         st.push(5);

//         reverse(st);

//         System.out.println(st);
//     }
// }
