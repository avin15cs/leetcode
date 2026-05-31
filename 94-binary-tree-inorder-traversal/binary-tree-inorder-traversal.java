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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     inOrder(root, list);
    //     return list;
    // }

    // private void inOrder(TreeNode root, List<Integer> list) {
    //     if(root==null)
    //         return;

    //     inOrder(root.left, list);
    //     list.add(root.val);
    //     inOrder(root.right, list);
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
}