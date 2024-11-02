

//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Pair
{
    int x;
    Node temp;
    Pair(int _x, Node _temp)
    {
        this.x = _x;
        this.temp = _temp;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root==null)
            return ans;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(0,root));
        
        while(!queue.isEmpty())
        {
            Pair curr = queue.remove();
            int x = curr.x;
            Node temp = curr.temp;
            
            if(!map.containsKey(x))
            {
                map.put(x,temp.data);
            }
            
            if(temp.left!=null)
            {
                queue.add(new Pair(x-1,temp.left));
            }
             if(temp.right!=null)
            {
                queue.add(new Pair(x+1,temp.right));
            }
        }
        
        for(Integer entry : map.values())
        {
            ans.add(entry);
        }
        return ans;
    }
}
