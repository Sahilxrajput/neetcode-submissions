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

    int cnt = 0;
    void traversal(TreeNode root, int max){
        if(root == null) return;

        if(root.val >= max){
            max = root.val;
            cnt++;
        } 

        traversal(root.left, max);
        traversal(root.right, max);

        return;
    }

    public int goodNodes(TreeNode root) {
        traversal(root, Integer.MIN_VALUE);
        return cnt;
    }
}
