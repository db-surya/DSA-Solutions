
public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {
        // Write your code here
        int ceil=-1;
        while(node!=null){
            if(node.data<x)
                node=node.right;
            else{
                ceil = node.data;
                node=node.left;
            }
        }
        return ceil;
    }
}