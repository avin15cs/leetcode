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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<Double> list=new ArrayList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            double sum=0; 
            for(int i=0;i<size;i++){
                TreeNode node=que.remove();
                sum+=node.val;

                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            list.add(sum/size);
        }

        return list;
    }
}