public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int floor=-1;
        while(root!=null){
            if(root.data>X)
                root=root.left;
            else{
                floor = root.data;
                root=root.right;
            }
        }
        return floor;
    }
}