class Solution {
    int globalMax = 0;
    public int maxDiamater(TreeNode root){
        if(root==null)  return 0;
        int leftHeight = maxDiamater(root.left);
        int rightHeight = maxDiamater(root.right);
        globalMax = Math.max(leftHeight+rightHeight,globalMax);
        return Math.max(leftHeight,rightHeight)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiamater(root);
        return globalMax;
    }
}