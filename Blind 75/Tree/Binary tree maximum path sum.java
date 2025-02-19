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
    int globalMax = Integer.MIN_VALUE;
    public int maxPath(TreeNode root){
        if(root==null) return 0;
        int leftSum = maxPath(root.left);
        int rightSum = maxPath(root.right);
        int[] possibilities = new int[]{leftSum+root.val,rightSum+root.val,root.val};
        int localMax = Integer.MIN_VALUE;
        for(int sum:possibilities){
            localMax = Math.max(localMax,sum);
        }
        int max = Math.max(localMax,leftSum+rightSum+root.val);
        globalMax = Math.max(max,globalMax);
        return localMax;
    }
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return globalMax;
    }
}