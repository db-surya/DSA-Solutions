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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> result =  new LinkedList<>();
        while(curr!=null)
        {
            if(curr.left==null)
            {
                //If left subtree doesn't exisit we move to the right
                result.add(curr.val);      
                curr=curr.right;         
            }
            else
            {
                //If left sub tree exists, we find the right most node 
                //link it to the curr
                TreeNode linker = curr.left;
                while(linker.right != null && linker.right !=curr)
                {
                    linker=linker.right;
                }
                if(linker.right==null)
                {
                    //Link the node to the prev
                    linker.right= curr;
                    curr=curr.left;
                }
                else
                {
                    //If the next node points to prev
                    //This link route is taken already cut the connection
                    //explore right nodes
                    linker.right=null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}