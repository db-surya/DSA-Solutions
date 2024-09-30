class Solution {
    public int checkHeight(TreeNode root){
        if(root==null) return 0;
        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);
        if(leftHeight==-1 || rightHeight==-1) return -1;
        if(Math.abs(leftHeight-rightHeight)>1) return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root)!=-1;
    }
}