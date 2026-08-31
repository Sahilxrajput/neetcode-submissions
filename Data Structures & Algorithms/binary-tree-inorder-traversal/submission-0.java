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
    List<Integer> inorder;

    void preOrder(TreeNode root){
        if(root == null) return;

        preOrder(root.left);
        inorder.add(root.val);
        preOrder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder = new ArrayList<>();
        preOrder(root);
        return inorder;
    }
}