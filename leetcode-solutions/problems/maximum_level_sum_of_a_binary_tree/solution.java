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
    // public int maxLevelSum(TreeNode root) {
    //     if(root == null)
    //         return 0;
        
    //     Queue<TreeNode> que = new LinkedList<>();

    //     que.add(root);

    //     int level = 0;
    //     int maxLevel=0;
    //     int sum=0;
    //     int maxSum=Integer.MIN_VALUE;
    //     int size=que.size();
    //     while(size!=0) {
    //         TreeNode node = que.remove();
    //         sum=sum+node.val;

    //         if(node.left!=null)
    //             que.add(node.left);
            
    //         if(node.right!=null)
    //             que.add(node.right);

    //         size--;

    //         if(size==0) {
    //             level++;
    //             if(maxSum<sum) {
    //                 maxSum=sum;
    //                 maxLevel=level;
    //             }
    //             sum=0;
    //             size = que.size();
    //         }
    //     }

    //     return maxLevel;
    // }

    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 0;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int maxLevel = 0;
        int level = 0;
        int maxSum = Integer.MIN_VALUE;

        while(!que.isEmpty()) {
            int size = que.size();
            int sum=0;
            level++;
            for(int i=0;i<size;i++) {
                TreeNode node = que.remove();
                sum+=node.val;
                if(node.left!=null)
                    que.add(node.left);

                if(node.right!=null)
                    que.add(node.right);
            }
            
            if(sum>maxSum) {
                maxSum=sum;
                maxLevel = level;
            }

        }

        return maxLevel;
    }
}