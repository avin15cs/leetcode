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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
        int pos=inorder.length-1;
        return helper(postorder,map,0,pos,new int[]{pos});
    }

    private TreeNode helper(int[] postorder, Map<Integer,Integer> map,int l, int r, int[] index) {
        if(l>r) return null;

        TreeNode node=new TreeNode(postorder[index[0]]);
        int currentIndex=map.get(postorder[index[0]]);
        index[0]--;
        node.right=helper(postorder,map,currentIndex+1,r,index);
        node.left=helper(postorder,map,l,currentIndex-1,index);


        return node;
    }
}