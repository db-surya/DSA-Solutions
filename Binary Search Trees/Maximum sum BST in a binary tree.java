class Node{
    int sum, min, max;
    Node(int s, int mn, int mx){
        this.sum = s;
        this.min = mn;
        this.max = mx;
    }
}
class Solution {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maximumBST(root);
        return maxSum;
    }
    public Node maximumBST(TreeNode root){
        if(root==null) 
            return new Node(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        Node left = maximumBST(root.left);
        Node right = maximumBST(root.right);
        if(!(left!=null  && right!=null && left.max < root.val && root.val<right.min))
            return null;
        int currSum = left.sum + right.sum + root.val;
        maxSum = Math.max(maxSum,currSum);
        int currMin = Math.min(left.min,root.val);
        int currMax = Math.max(right.max,root.val);
        return new Node(currSum,currMin,currMax);
    }
}