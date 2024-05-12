class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node prev = null;
    Node inOrder(Node root){
        if(root==null) return root;
	    inOrder(root.left);
	    root.left = prev;
	    if(prev!=null)
	        prev.right = root;
	    prev = root;
	    inOrder(root.right);
	    return root;
    }
    Node bToDLL(Node root)
    {
	    //  Your code here
	    inOrder(root);
	    while(root!=null && root.left!=null)
	        root=root.left;
	    return root;
    }
}