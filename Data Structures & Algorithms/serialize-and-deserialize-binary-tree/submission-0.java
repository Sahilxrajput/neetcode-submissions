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

    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(root);

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(node == null){
                sb.append("N,");
                continue;
            }

            sb.append(node.val + ",");

            q.add(node.left);
            q.add(node.right);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        
        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int i=1;

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(!values[i].equals("N")){
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.left);
            }
            i++;
            
            if(!values[i].equals("N")){
                node.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
}