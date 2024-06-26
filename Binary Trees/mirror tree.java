class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node==null) 
            return;
        Node temp = null;
        temp = node.right;
        node.right = node.left;
        node.left = temp;
        mirror(node.left);
        mirror(node.right);
    }
}