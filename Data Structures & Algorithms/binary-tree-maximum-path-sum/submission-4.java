class Solution {
    private int MAX = Integer.MIN_VALUE;

    private int sum(TreeNode root) {
        if (root == null) return 0;

        // Clamp negative paths to 0 immediately!
        int leftSum = Math.max(0, sum(root.left));
        int rightSum = Math.max(0, sum(root.right));

        // left and right are guaranteed to be >= 0, 
        MAX = Math.max(MAX, leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        sum(root);        
        return MAX;
    }
}