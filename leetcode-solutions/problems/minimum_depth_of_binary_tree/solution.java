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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
         
        return (left==0||right==0)?left+right+1:1+Math.min(left,right);
    }

    // public int minDepth(TreeNode root) {
    //     if(root==null)
    //         return 0;
        
    //     Queue<TreeNode> queue=new LinkedList<>();

    //     queue.add(root);
    //     int level=1;

    //     while(!queue.isEmpty()) {
    //         int size=queue.size();

    //         for(int i=0;i<size;i++) {
    //             TreeNode curNode=queue.remove();
    //             if(curNode.left==null && curNode.right==null)
    //                 return level;
                
    //             if(curNode.left!=null)
    //                 queue.add(curNode.left);

    //             if(curNode.right!=null)
    //                 queue.add(curNode.right);
    //         }
    //         level++;
    //     }
    //     return level;
    // }

}