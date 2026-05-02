class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val, null, null);

        if(root.val > val && root.left == null) {
            root.left = new TreeNode(val, null, null);
        }
        if(root.val < val && root.right == null) {
            root.right = new TreeNode(val, null, null);
        }

        if(val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }

        return root;
        
    }
}