class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        if(adj.get(0).size()==0) return result;
        HashSet<Integer>visited = new HashSet<>();
        LinkedList<Integer>queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty())
        {
            int parent = queue.remove();
            result.add(parent);
            for(int i=0;i<adj.get(parent).size();i++)
            {
                int child = adj.get(parent).get(i);
                if(!visited.contains(child))
                {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
        return result;
    }
}

/*Notes
 * 1. Here marking the child as visited before adding to the queue is important because 
 * that child can be visited by someone else again and traverse again which leads to wrong ans
 * 
 * 
 */