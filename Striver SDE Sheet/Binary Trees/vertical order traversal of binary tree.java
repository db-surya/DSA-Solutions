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
class Pair
{
    TreeNode root;
    int xCordinate;
    int yCordinate;
    
    Pair(TreeNode _root, int _x, int _y)
    {
        this.root = _root;
        this.xCordinate = _x;
        this.yCordinate = _y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        
        if(root==null)
            return ans;
            
        queue.add(new Pair(root,0,0));
        
        //Level order traversal
        while(!queue.isEmpty())
        {
            int queueSize = queue.size();
            
            for(int i=0;i< queueSize; i++)
            {
                Pair curr = queue.remove();
                TreeNode tempRoot = curr.root;
                int xVal = curr.xCordinate;
                int yVal = curr.yCordinate;
                
                //Adding current pair(Node) to the treemap
                if(!map.containsKey(xVal))
                {
                    //If this is the first entry for the x create new treemap
                    map.put(xVal, new TreeMap<>());
                }
                if(!map.get(xVal).containsKey(yVal))
                {
                    //If this is the first entry for the y for corresponding x create new priority queue
                    map.get(xVal).put(yVal, new PriorityQueue<>());
                }
                map.get(xVal).get(yVal).add(tempRoot.val);
                
                if(tempRoot.left!=null)
                {
                    queue.add(new Pair(tempRoot.left,xVal-1, yVal+1));
                }
                if(tempRoot.right!=null)
                {
                    queue.add(new Pair(tempRoot.right, xVal+1, yVal+1));
                }
                
            }
        }
        
        //Iterate the treemap and populate the ans list
        for(TreeMap<Integer,PriorityQueue<Integer>> yMap : map.values())
        {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pQueue:yMap.values())
            {
                     while(!pQueue.isEmpty())
                     {
                         ans.get(ans.size()-1).add(pQueue.remove());
                     }
            }
        }
        return ans;
    }
}