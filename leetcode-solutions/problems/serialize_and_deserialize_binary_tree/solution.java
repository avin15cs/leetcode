/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return null;

        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            TreeNode node=que.remove();

            if(node==null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");
            que.add(node.left);
            que.add(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)
            return null;
        
        String[] values=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        int i=1;

        while(!que.isEmpty()) {
            TreeNode parent=que.remove();

            if(!values[i].equals("null")) {
                parent.left=new TreeNode(Integer.parseInt(values[i]));
                que.add(parent.left);
            }

            i++;

            if(!values[i].equals("null")) {
                parent.right=new TreeNode(Integer.parseInt(values[i]));
                que.add(parent.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));