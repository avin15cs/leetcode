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
    public int goodNodes(TreeNode root) {
        return solve(root,root.val);
    }

    int solve(TreeNode node, int maxSoFar) {
        if(node==null)
            return 0;
        
        int good=0;

        if(node.val>=maxSoFar){
            good=1;
            maxSoFar=node.val;
        }

        good+=solve(node.left,maxSoFar);
        good+=solve(node.right,maxSoFar);

        return good;
    }
}