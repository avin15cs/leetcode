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
    public int sumNumbers(TreeNode root) {
        if(root==null)  
            return 0;
        
        int sum=sum(root,"");
        return sum;
    }

    private int sum(TreeNode root, String sum) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) return Integer.valueOf(sum+root.val);
        // System.out.println(root.val);
        return sum(root.left,sum+root.val)+sum(root.right,sum+root.val);
    }
}