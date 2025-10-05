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
    // int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);

        return helper(preorder,map,0,inorder.length-1,new int[]{0});
    }

    private TreeNode helper(int[] preorder,Map<Integer,Integer> map, int l, int r,int[] index) {
        if(l>r) return null;

        TreeNode node=new TreeNode(preorder[index[0]]);
        int currentIndex=map.get(preorder[index[0]]);
        index[0]++;
        node.left=helper(preorder,map,l,currentIndex-1,index);
        node.right=helper(preorder,map,currentIndex+1,r,index);

        return node;
    }
}