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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res=0;
        solve(root);
        return res;
    }

    int solve(TreeNode root) {
        if(root==null)
            return 0;

        int l=solve(root.left);
        int r=solve(root.right);

        res=Math.max(res,l+r);

        return 1+Math.max(l,r);

    }
    // int solve(TreeNode root) {
    //     if (root == null) return 0;

    //     int l = solve(root.left);   // ✅ correct recursive call
    //     int r = solve(root.right);  // ✅ correct recursive call

    //     // Longest path *through* this node = left height + right height
    //     res = Math.max(res, l + r);

    //     // Height of this node = 1 + max(left height, right height)
    //     return 1 + Math.max(l, r);
    // }
}