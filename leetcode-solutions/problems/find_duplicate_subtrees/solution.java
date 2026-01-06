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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        dfs(root,map,list);
        return list;
    }

    String dfs(TreeNode root, Map<String,Integer> map, List<TreeNode> list) {
        if(root==null) {
            return "#";
        }

        String left=dfs(root.left,map,list);
        String right=dfs(root.right,map,list);

        String ans = root.val+","+left+","+right;

        map.put(ans,map.getOrDefault(ans,0)+1);

        if(map.get(ans)==2)
            list.add(root);

        return ans;
    }
}