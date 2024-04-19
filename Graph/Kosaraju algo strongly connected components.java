class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(int index, Stack<Integer>stack,ArrayList<ArrayList<Integer>>adj,HashSet<Integer>visited){
        for(int i=0;i<adj.get(index).size();i++){
            int child = adj.get(index).get(i);
            if(!visited.contains(child)){
                visited.add(child);
                dfs(child,stack,adj,visited);
            }
        }
        stack.add(index);
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        HashSet<Integer>visited = new HashSet<>();
        Stack<Integer>stack = new Stack<>();
        for(int i=0;i<adj.size();i++){
            if(!visited.contains(i)){
                visited.add(i);
                dfs(i,stack,adj,visited);
            }
        }
        ArrayList<ArrayList<Integer>>inversed = new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            inversed.add(new ArrayList<Integer>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                int child = adj.get(i).get(j);
                inversed.get(child).add(i);
            }
        }
        visited.clear();
        int count = 0;
        while(!stack.isEmpty()){
            int child = stack.pop();
            if(!visited.contains(child)){
                count++;
                visited.add(child);
                dfs(child,new Stack<>(),inversed,visited);
            }
        }
        return count;
    }
}