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
        if(root==null)   return 0;
        
        int l=maxSum(root.left);
        int r=maxSum(root.right);
        
        int temp=Math.max(Math.max(l,r)+root.val,root.val);
        int temp2=Math.max(l+r+root.val,temp);
        ans=Math.max(temp2,ans);
        
        return temp;
    }
}