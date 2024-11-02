

//User function Template for Java

class Pair
{
    int xCordinate;
    Node temp;
    Pair(int x, Node _temp)
    {
        this.xCordinate = x;
        this.temp = _temp;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
            
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            int xVal = p.xCordinate;
            Node temp = p.temp;
            map.put(xVal, temp.data);
            
            if(temp.left!=null)
                q.add(new Pair(xVal-1, temp.left));
                
            if(temp.right!=null)
                q.add(new Pair(xVal+1, temp.right));
        }
        
        for(Integer entry : map.values())
        {
            ans.add(entry);
        }
        
        return ans;
    }
}




