class Solution
{
    //Function to return list containing vertices in Topological order. 
    static void dfs(int index,HashSet<Integer>visited,ArrayList<ArrayList<Integer>>adj,Stack<Integer>st)
    {
        for(int i=0;i<adj.get(index).size();i++)
        {
            int child = adj.get(index).get(i);
            if(!visited.contains(child))
            {
                visited.add(child);
                dfs(child,visited,adj,st);
            }
        }
        st.add(index);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        HashSet<Integer>visited = new HashSet<>();
        Stack<Integer>st = new Stack();
        for(int i=0;i<adj.size();i++)
        {
            if(!visited.contains(i))
            {
                visited.add(i);
                dfs(i,visited,adj,st);
            }
        }
        int[]ans = new int[st.size()];
        int count = 0;
        while(!st.isEmpty())
        {
            ans[count++]=st.pop();
        }
        return ans;
    }
}