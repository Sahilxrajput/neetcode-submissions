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

    List<Integer> PostOrder;

    void PostOrder(TreeNode root){
        if(root == null) return;

        PostOrder(root.left);
        PostOrder(root.right);
        PostOrder.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        PostOrder = new ArrayList<>();
        PostOrder(root);
        return PostOrder;
    }
}