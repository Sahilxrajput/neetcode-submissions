class Solution {
    private long MAX = Integer.MIN_VALUE;

    private long sum(TreeNode root){
        if(root == null) return 0;

        long leftSum = sum(root.left);
        long rightSum = sum(root.right);

        // max(left, right, left + right + root.val, root.val)

        MAX = Math.max(MAX, leftSum + root.val);
        MAX = Math.max(MAX, rightSum + root.val);
        MAX = Math.max(MAX, leftSum + rightSum + root.val);
        MAX = Math.max(MAX, root.val);

        return Math.max(Math.max(leftSum, rightSum)+root.val, root.val);
    }

    public int maxPathSum(TreeNode root) {
        sum(root);        
        return (int)MAX;
    }
}
