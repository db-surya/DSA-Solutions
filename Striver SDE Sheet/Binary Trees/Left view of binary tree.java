

//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      Queue<Node> queue = new LinkedList<>();
      ArrayList<Integer> ans = new ArrayList<>();
      if(root==null)
        return ans;
      queue.add(root);
      while(!queue.isEmpty())
      {
          int size = queue.size();
          for(int i=0;i<size;i++)
          {
          Node curr = queue.remove();
          if(i==0)
            ans.add(curr.data);
          if(curr.left!=null)
            queue.add(curr.left);
          if(curr.right!=null)
            queue.add(curr.right);
          }
      }
      return ans;
    }
}