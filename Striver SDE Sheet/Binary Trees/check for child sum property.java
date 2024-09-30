public class Solution {
    public static int childSum(Node root){
        if(root==null) 
            return 0;
        if(root.left == null && root.right==null) 
            return root.data;
        int leftSum = childSum(root.left);
        int rightSum = childSum(root.right);
        if(leftSum == -1 || rightSum == -1)
            return -1;
        else if(leftSum+rightSum!=root.data)
            return -1;
        return leftSum+rightSum;
    }
    public static boolean isParentSum(Node root) {
        // Write your code here.
        return childSum(root)!=-1;
    }
}