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
    boolean isBalancedHeight;

    int height(TreeNode root){
        if(root == null) return 0;

        int lh = 1 + height(root.left);
        int rh = 1 + height(root.right);

        if(Math.abs(lh - rh)  > 1) isBalancedHeight = false;

        return Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        isBalancedHeight = true;
        height(root);
        return isBalancedHeight;
    }
}
