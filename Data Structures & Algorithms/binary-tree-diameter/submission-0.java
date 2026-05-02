class Solution {
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDia;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);

        maxDia = Math.max(maxDia, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
