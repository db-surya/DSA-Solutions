class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Pair{
        int distance;
        int node;
        Pair(int d, int n){
            this.distance = d;
            this.node = n;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair>pq = new PriorityQueue<>((x,y)->x.distance-y.distance);
        int[]dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new Pair(0,S));
        dist[S]=0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int currentNode = curr.node;
            int currentDistance = curr.distance;
            for(int i=0;i<adj.get(currentNode).size();i++){
                int neighbourNode = adj.get(currentNode).get(i).get(0);
                int neighbourDistance = adj.get(currentNode).get(i).get(1);
                if(currentDistance+neighbourDistance < dist[neighbourNode]){
                    dist[neighbourNode] = currentDistance+neighbourDistance;
                    pq.add(new Pair(currentDistance+neighbourDistance,neighbourNode));
                }
            }
        }
        return dist;
    }
}