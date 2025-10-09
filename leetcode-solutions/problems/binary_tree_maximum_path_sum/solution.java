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
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return ans;
    }

    private int maxSum(TreeNode root){
        if(root==null)  return 0;
        int left=maxSum(root.left);
        int right=maxSum(root.right);
        int temp=Math.max(Math.max(left,right)+root.val,root.val);
        int temp1=Math.max(root.val+left+right,temp);
        ans=Math.max(ans,temp1);

        return temp;
    }
}