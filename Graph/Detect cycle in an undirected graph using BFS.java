class Solution {
    class Pair
    {
        int parent;
        int current;
        Pair(int p, int c)
        {
            this.parent = p;
            this.current = c;
        }
    }
    public boolean detectCycle(int index, HashSet<Integer>visited, ArrayList<ArrayList<Integer>>adj)
    {
        LinkedList<Pair>queue = new LinkedList<>();
        queue.add(new Pair(-1,index));
        visited.add(index);
        while(!queue.isEmpty())
        {
            Pair p = queue.remove();
            int parent = p.parent;
            int current = p.current;
            for(int i=0;i<adj.get(current).size();i++)
            {
                int child = adj.get(current).get(i);
                if(visited.contains(child) && child!=parent)
                    return true;
                //below condition is imp, only if not visited add it to queue or will lead to infinite
                else if(!visited.contains(child))
                {
                    queue.add(new Pair(current,child));
                    visited.add(child);
                }
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        HashSet<Integer>visited = new HashSet<>();
        for(int i=0;i<adj.size();i++)
        {
            if(!visited.contains(i))
            {
                if(detectCycle(i, visited, adj))
                    return true;
            }
        }
        return false;
    }
}