
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer>result = new ArrayList<>();
        if(adj.get(0).size()==0)
            return result;
        HashSet<Integer>visited = new HashSet<>();
        visited.add(0);
        result.add(0);
        DFS(0,visited,result,adj);
        return result;
    }
    public void DFS(int index, HashSet<Integer>visited, ArrayList<Integer>result, ArrayList<ArrayList<Integer>> adj)
    {
        for(int i=0;i<adj.get(index).size();i++)
        {
            int child = adj.get(index).get(i);
            if(!visited.contains(child))
            {
                visited.add(child);
                result.add(child);
                DFS(child, visited, result, adj);
            }
        }
        return;
    }
}