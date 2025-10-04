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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        boolean leftToRight=true;
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> ilist=new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node=que.remove();
                ilist.add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            if(leftToRight) {
                list.add(ilist);
            } else {
                Collections.reverse(ilist);
                list.add(ilist);
            }
            leftToRight=!leftToRight;
        }

        return list;
    }
}