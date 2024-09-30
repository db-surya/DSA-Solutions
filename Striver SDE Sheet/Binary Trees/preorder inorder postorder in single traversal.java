import java.util.*;

public class Solution {
    static class Pair{
    TreeNode root;
    int index;
    Pair(TreeNode r,int ind){
        this.root = r;
        this.index = ind;
    }
}
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        Stack<Pair>stack = new Stack<>();
        stack.push(new Pair(root,1));
        List<Integer>preorder = new ArrayList<>();
        List<Integer>inorder = new ArrayList<>();
        List<Integer>postorder = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        while(!stack.isEmpty()){
            Pair node = stack.pop();
            TreeNode curr = node.root;
            if(node.index==1){
                preorder.add(curr.data);
                node.index++;
                stack.push(node);
                if(curr.left!=null){
                    stack.push(new Pair(curr.left,1));
                }
            }
            else if(node.index == 2){
                inorder.add(curr.data);
                node.index++;
                stack.push(node);
                if(curr.right!=null){
                    stack.push(new Pair(curr.right,1));
                }
            }
            else{
                postorder.add(curr.data);
            }
        }
        ans.add(inorder);
        ans.add(preorder);
        ans.add(postorder);
        return ans;
    }
}