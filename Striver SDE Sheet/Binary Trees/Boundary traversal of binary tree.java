import java.util.*;

public class Solution {
    public static Boolean isLeaf(TreeNode root){
        if(root==null) return false;
        return root.left==null && root.right==null;
    }
    public static void leftSubTree(TreeNode root, List<Integer>ans){
        if(root==null) return;
        if(isLeaf(root)) return;
        ans.add(root.data);
        if(root.left!=null) 
            leftSubTree(root.left,ans);
        else
            leftSubTree(root.right,ans);
    }
    public static void inOrderTraverse(TreeNode root, List<Integer>ans){
        if(root==null) return;
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        inOrderTraverse(root.left, ans);
        inOrderTraverse(root.right, ans);
    }
    public static void rightSubTree(TreeNode root, List<Integer>temp){
        if(root==null) return;
        if(isLeaf(root)) return;
        temp.add(root.data);
        if(root.right!=null) 
            rightSubTree(root.right,temp);
        else
            rightSubTree(root.left,temp);
    }
    public static void reverseRighTree(List<Integer>ans, List<Integer>temp){
        while(temp.size()>0){
            ans.add(temp.remove(temp.size()-1));
        }
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer>ans = new ArrayList<>();
        if(root==null) return ans;
        ans.add(root.data);
        leftSubTree(root.left, ans);
        inOrderTraverse(root.left,ans);
        inOrderTraverse(root.right,ans);
        List<Integer>temp = new ArrayList<>();
        rightSubTree(root.right,temp);
        reverseRighTree(ans, temp);
        return ans;
    }
}