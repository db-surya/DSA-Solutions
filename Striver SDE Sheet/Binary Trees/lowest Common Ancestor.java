class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)  return null;
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
        if((leftNode==p && rightNode == q) ||(leftNode==q && rightNode==p))
         return root;
        if(root == p || root==q) return root;
        return leftNode==null?rightNode:leftNode;
    }
}