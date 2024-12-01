class Solution {
    // Function to return a list containing the postorder traversal of the tree.
    void postOrderTraversal(Node root,ArrayList<Integer>ans){
        if(root!=null){
            postOrderTraversal(root.left,ans);
            postOrderTraversal(root.right,ans);
            ans.add(root.data);
        }
    }
    ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer>ans = new ArrayList<>();
        postOrderTraversal(root,ans);
        return ans;
    }
}