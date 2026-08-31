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
    Map<Integer, Integer> inMap = new HashMap<>();

    TreeNode build(int[] preorder, int preStart, int preEnd, int[]inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;
        
        root.left = build(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1);
        root.right = build(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd);
        
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n =inorder.length;

        for(int i =0; i<n; ++i){
            inMap.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, n-1, inorder, 0, n-1);
        return root;
    }
}