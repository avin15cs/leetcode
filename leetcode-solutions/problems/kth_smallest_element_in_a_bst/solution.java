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
        // if(root==null)  return 0;

        kth(root, new int[]{k});
        return res;

    }

    int res=Integer.MIN_VALUE;
    private void kth(TreeNode root, int[] pos){
        if(root==null)
            return;
        
        if(res!=Integer.MIN_VALUE)
            return;

        kth(root.left,pos);
        pos[0]--;
        if(pos[0]==0)
            res=root.val;
        kth(root.right,pos);        
    }

}