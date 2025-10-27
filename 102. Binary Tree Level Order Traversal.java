public class 102. Binary Tree Level Order Traversal {
    
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int height(TreeNode root){
        if(root == null) return 0 ;
        if(root.left ==null && root.right == null) return 0;

        return 1+ Math.max(height(root.left) ,height(root.right));
    }

    public void levelOrder(TreeNode root , int n , List<Integer>  ans){
        if(root == null) return;

        if(n==1){
            ans.add(root.val);
            return;
        }

        levelOrder(root.left,n-1,ans);
        levelOrder(root.right,n-1,ans);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        int level = height(root) + 1;

        for(int i=1; i<= level; i++){
            List<Integer> arr = new ArrayList<>();
            levelOrder(root, i, arr);
            ans.add(arr);
        }

        return ans;
    }
}