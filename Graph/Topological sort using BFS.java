class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int count = 0;
        int[] ans = new int[V];
        int[] indegree = new int[V];
        for(int i=0;i<V;i++)
        {
            ArrayList<Integer>node = adj.get(i);
            for(int j=0;j<node.size();j++)
            {
                int val = adj.get(i).get(j);
                indegree[val]++;
            }
        }
        LinkedList<Integer>queue = new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
                ans[count]=i;
                count++;
            }
        }
        while(!queue.isEmpty())
        {
            int node = queue.remove();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int child =  adj.get(node).get(i);
                indegree[child]--;
                if(indegree[child]==0)
                {
                    queue.add(child);
                    ans[count]=child;
                    count++;
                }
            }
        }
        return ans;
    }
}
