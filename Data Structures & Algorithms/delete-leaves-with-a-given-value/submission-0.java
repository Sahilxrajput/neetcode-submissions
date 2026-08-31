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
    private boolean remove(TreeNode root, int tar){
        if(root == null) return false;
        // if(root.left == null && root.right == null)    
        //     return root.val == tar;

        boolean left = remove(root.left, tar);
        boolean right = remove(root.right, tar);

        if(left) root.left = null;
        if(right) root.right = null;
        
        if(root.left == null && root.right == null)    
            return root.val == tar;

        return false;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        remove(root, target);
        if(root.left == null && root.right == null && root.val == target) return null;    

        return root;
    }
}