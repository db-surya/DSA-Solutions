class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>>adjacencyList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }    
        for(int flight[]:flights){
            int source = flight[0];
            int destination = flight[1];
            int cost = flight[2];
            adjacencyList.get(source).add(new int[]{destination,cost});
        }
        Queue<int[]>queue = new LinkedList<>();
        int dist[] = new int[n];
        dist[src] = 0;
        Arrays.fill(dist,Integer.MAX_VALUE);
        queue.add(new int[]{0,src,0});
        // [stops, node, cost]
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int stops = top[0];
            int node = top[1];
            int cost = top[2];
            if(stops>k) continue;
            for(int i=0;i<adjacencyList.get(node).size();i++){
                int neighbourList[] = adjacencyList.get(node).get(i);
                int neighbour = neighbourList[0];
                int neighbourCost = neighbourList[1];
                if(dist[neighbour]>cost+neighbourCost){
                    dist[neighbour] = cost+neighbourCost;
                    queue.add(new int[]{stops+1,neighbour,cost+neighbourCost});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
}