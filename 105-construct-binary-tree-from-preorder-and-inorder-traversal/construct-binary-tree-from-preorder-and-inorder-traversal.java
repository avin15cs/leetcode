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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);

        return helper(preorder, map, 0, inorder.length-1);
    }

    TreeNode helper(int[] preorder, Map<Integer, Integer> map, int l, int r) {
        if(l>r)
            return null;
        
        TreeNode node = new TreeNode(preorder[index]);
        int currentIndex = map.get(preorder[index]);
        index++;

        node.left = helper(preorder, map, l, currentIndex-1);
        node.right = helper(preorder, map, currentIndex+1, r);

        return node;
    }
}