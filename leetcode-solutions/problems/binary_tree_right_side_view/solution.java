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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>  list = new LinkedList<>();
        if(root == null)    return list;
        
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);


        // list.add(root.val);

        int size = que.size();
        System.out.println("size:" + size );

        while(size!=0) {
            TreeNode curNode = que.remove();
            if(curNode.left!=null)
                que.add(curNode.left);

            if(curNode.right!=null)
                que.add(curNode.right);

            size--;
            if(size == 0) {
                list.add(curNode.val);
                size = que.size();
            }
        }

        return list;

    }
}