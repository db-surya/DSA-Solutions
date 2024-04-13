class Solution {
    // Function to detect cycle in a directed graph.
    public boolean detectCycle(int index, HashSet<Integer>visited, HashSet<Integer>dfsVisited,ArrayList<ArrayList<Integer>>adj)
    {
        for(int i=0;i<adj.get(index).size();i++)
        {
            int child = adj.get(index).get(i);
            if(visited.contains(child) && dfsVisited.contains(child))
                return true;
            else if(!visited.contains(child))
            {
                visited.add(child);
                dfsVisited.add(child);
                if(detectCycle(child,visited,dfsVisited,adj))
                    return true;
                dfsVisited.remove(child);
            }
        }
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        HashSet<Integer>visited = new HashSet<>();
        HashSet<Integer>dfsVisited = new HashSet<>();
        for(int i=0;i<adj.size();i++)
        {
            if(!visited.contains(i))
            {
                visited.add(i);
                dfsVisited.add(i);
                if(detectCycle(i,visited,dfsVisited,adj))
                    return true;
                dfsVisited.remove(i);
            }
        }
        return false;
    }
}