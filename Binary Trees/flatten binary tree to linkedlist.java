class Solution {
    TreeNode prev = null;
    public void flattenTree(TreeNode root){
        if(root==null) 
            return;
        flattenTree(root.right);
        flattenTree(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
}