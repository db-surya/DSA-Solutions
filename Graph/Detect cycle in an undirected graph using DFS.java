class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean detectCycle(int index,int parent, HashSet<Integer>visited,ArrayList<ArrayList<Integer>>adj)
    {
            for(int i=0;i<adj.get(index).size();i++)
            {
                int child = adj.get(index).get(i);
                if(visited.contains(child) && child!=parent)
                    return true;
                else if(!visited.contains(child))
                {
                    visited.add(child);
                    //below condition is very imp, instead of calling and forgetting
                    //Call it check if it returns true and return it below
                    if(detectCycle(child, index, visited, adj))
                        return true;
                }
            }
            return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        HashSet<Integer>visited = new HashSet<>();
        for(int i=0;i<adj.size();i++)
        {
            if(!visited.contains(i))
            {
                visited.add(i);
                if(detectCycle(i,-1,visited,adj))
                    return true;
            }
        }
        return false;
    }
}

/*Notes
 * Recursion needs to be handled properly in the else if
 * First I added like if the recursion ends I'll go down to the loop and return false which is wrong
 * check what the recursion is returning and return that to the below function
 */