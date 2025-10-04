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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        int size=que.size();
        List<Integer> ilist=new ArrayList<>();
        while(size!=0){
            TreeNode node=que.remove();
            ilist.add(node.val);
            if(node.left!=null) que.add(node.left);
            if(node.right!=null) que.add(node.right);
            size--;
            if(size==0){
                size=que.size();
                list.add(ilist);
                ilist=new ArrayList<>();
            }
        }

        // while(!que.isEmpty()){
        //     int size=que.size();
        //     List<Integer> ilist=new ArrayList<>();
        //     for(int i=0;i<size;i++) {
        //         TreeNode node=que.remove();
        //         ilist.add(node.val);
        //         if(node.left!=null) que.add(node.left);
        //         if(node.right!=null) que.add(node.right);
        //     }
        //     list.add(ilist);
        // }

        return list;
    }
}