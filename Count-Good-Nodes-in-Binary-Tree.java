1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int goodNodes(TreeNode root) {
18        return dfs(root, root.val);
19    }
20
21    private int dfs(TreeNode Node ,int maxval){
22        if(Node == null){
23            return 0;
24        }
25        int count = 0;
26
27        if(Node.val >= maxval){
28            count =1;
29        }
30
31        maxval = Math.max(Node.val, maxval);
32        
33        count += dfs(Node.left,maxval);
34        count += dfs(Node.right, maxval);
35
36        return count;
37    }
38}