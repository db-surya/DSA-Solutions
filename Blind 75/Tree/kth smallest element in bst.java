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
    int ans = 0,count=0;
    public void kthSmall(TreeNode root, int k){
        if(root==null) return;
        kthSmall(root.left,k);
        count++;
        if(count==k){
            ans = root.val;
            return;
        }
        kthSmall(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        kthSmall(root,k);
        return ans;
    }
}