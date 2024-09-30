class Solution {
    public boolean dfs(int[][]graph,int[]visited,int parent){
        for(int i=0;i<graph[parent].length;i++){
            int child = graph[parent][i];
            if(visited[child]==visited[parent]){
                return false;
            }
            else if(visited[child]==-1){
                visited[child] = 1-visited[parent];
                if(!dfs(graph,visited,child))
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[]visited = new int[graph.length];
        Arrays.fill(visited,-1);
        for(int i=0;i<graph.length;i++)
        {
            if(visited[i]==-1)
            {
                visited[i] = 0;
                if(!dfs(graph,visited,i))
                    return false;
            }
        }
        return true;
    }
}
