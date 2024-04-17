class Solution {
    public boolean bfs(int[][]graph,int[]visited,LinkedList<Integer>queue){
        while(!queue.isEmpty()){
            int parent = queue.remove();
            for(int i=0;i<graph[parent].length;i++){
                int child = graph[parent][i];
                if(visited[child]==visited[parent])
                    return false;
                else if(visited[child]==-1){
                    visited[child]=1-visited[parent];
                    queue.add(child);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
       int[]visited = new int[graph.length];
       Arrays.fill(visited,-1);
       LinkedList<Integer>queue = new LinkedList<>();
       for(int i=0;i<graph.length;i++)
       {
            if(visited[i]==-1)
            {
                queue.add(i);
                visited[i]=0;
                if(!bfs(graph,visited,queue))
                    return false;
            }
       }
       return true;
    }
}
