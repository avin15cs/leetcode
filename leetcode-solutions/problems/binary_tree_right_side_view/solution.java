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

    //BFS approach
    // public List<Integer> rightSideView(TreeNode root) {

    //     Queue<TreeNode> que=new LinkedList<>();
    //     List<Integer> list=new ArrayList<>();
    //     if(root==null) return list;
        
    //     que.add(root);

    //     while(!que.isEmpty()) {
    //         int size=que.size();

    //         for(int i=0;i<size;i++) {
    //             TreeNode node=que.remove();
                
    //             if(i==size-1)
    //                 list.add(node.val);

    //             if(node.left!=null)
    //                 que.add(node.left);

    //             if(node.right!=null)
    //                 que.add(node.right);
    //         }
    //     }

    //     return list;
    // }

    //DFS Approach
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        solve(root,0,list);
        return list;
    }

    void solve(TreeNode root, int depth, List<Integer> list) {
        if(root==null)
            return;

        if(list.size()==depth)
            list.add(root.val);
        
        solve(root.right,depth+1,list);
        solve(root.left,depth+1,list);
    }
}