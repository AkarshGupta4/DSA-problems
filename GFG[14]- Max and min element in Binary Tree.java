/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public static int findMax(Node root) {
        // code here
        if (root == null) return Integer.MIN_VALUE;
        
        int a = root.data;
        int b = findMax(root.left);
        int c = findMax(root.right);
        return Math.max(a,Math.max(b,c));
    }

    public static int findMin(Node root) {
        
        // code here
        
        if (root == null) return Integer.MAX_VALUE;
        
        int a = root.data;
        int b = findMin(root.left);
        int c = findMin(root.right);
        return Math.min(a,Math.min(b,c));
    }
    
    
}