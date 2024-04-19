class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[]dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = i==S?0:(int)1e8;
        }
        //Bellman ford n-1 iterations
        for(int i=0;i<V;i++){
            for(int j=0;j<edges.size();j++){
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);
                if(dist[u]!=1e8 && dist[u]+wt<dist[v]){
                    dist[v] =  dist[u]+wt;
                }
            }
        }
        //detect negative cycle
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int wt = edges.get(i).get(2);
            if(dist[u]!=1e8 && dist[u]+wt<dist[v]){
                return new int[]{-1};      
            }
        }
        return dist;
    }
}
