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

    class Node{
        int h, dia;
        public Node(int h, int dia){
            // this.rh = rh;            
            this.h = h;            
            this.dia = dia;            
        }
    }

    private Node maxDepth(TreeNode root) {
        if(root == null) return new Node(0, 0);
        
        Node left = maxDepth(root.left);
        Node right = maxDepth(root.right);
        
        int nh = Math.max(left.h, right.h) + 1;
        int newDia = left.h + right.h;
        
        newDia = Math.max(newDia, Math.max(left.dia, right.dia));

        return new Node(nh, newDia);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return maxDepth(root).dia;
    }
}
