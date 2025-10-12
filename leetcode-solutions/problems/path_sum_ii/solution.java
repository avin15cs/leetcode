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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return sum(root,targetSum, new ArrayList<>());
    }

    private List<List<Integer>> sum(TreeNode root, int targetSum, List<Integer> res) {

    List<List<Integer>> list = new ArrayList<>();

    if (root == null)
        return list;

    // Create a new path list for each recursive call to avoid sharing same list
    List<Integer> path = new ArrayList<>(res);
    path.add(root.val);

    // If it's a leaf and the sum matches, add the path to result
    if (root.left == null && root.right == null && root.val == targetSum) {
        list.add(path);
        return list;
    }

    // Recurse left and right
    list.addAll(sum(root.left, targetSum - root.val, path));
    list.addAll(sum(root.right, targetSum - root.val, path));

    return list;
    }
}