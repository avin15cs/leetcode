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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null||subRoot==null) return root==subRoot;

        boolean chek = false;
        if(root.val==subRoot.val) {
            chek=checkSubtree(root,subRoot);
        }
            
        if(chek) return true;
        
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }


    boolean checkSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null||subRoot==null) return root==subRoot;

        if(root.val!=subRoot.val)   return false;

        return checkSubtree(root.left,subRoot.left) && checkSubtree(root.right,subRoot.right);
    }
}