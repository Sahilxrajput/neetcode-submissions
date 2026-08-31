class Solution {
    List<Integer> list;
    void preOrder(TreeNode root){
        if(root == null) return;

        preOrder(root.left);
        list.add(root.val);
        preOrder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
       list = new ArrayList<>();
       preOrder(root);

       return list.get(k-1);
    }
}