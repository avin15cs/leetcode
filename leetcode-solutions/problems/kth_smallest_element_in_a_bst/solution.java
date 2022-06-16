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
    public int kthSmallest(TreeNode root, int k) {
        
        traverse(root,k);
        return result;
    }
    
    int count=0;
    int result=Integer.MIN_VALUE;
    private void traverse(TreeNode root, int k){
        if(root==null)  return;
        
        // if(result!=Integer.MIN_VALUE)   return;
        
        traverse(root.left,k);
        count++;
        if(count==k)    result=root.val;        
        if(count<k) traverse(root.right, k);
        
    }
}