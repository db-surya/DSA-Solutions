class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>>adjacencyList = new ArrayList<>();
        int n = points.length;
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int xDistance = Math.abs(points[i][0]-points[j][0]);
                int yDistance = Math.abs(points[i][1]-points[j][1]);
                int manhattanDistance = xDistance+yDistance;
                adjacencyList.get(i).add(new int[]{j,manhattanDistance});
                adjacencyList.get(j).add(new int[]{i,manhattanDistance});
            }
        }
        PriorityQueue<int[]>minHeap = new PriorityQueue<>((x,y)->x[1]-y[1]);
        HashSet<Integer>visited = new HashSet<>();
        minHeap.add(new int[]{0,0});
        int cost = 0;
        while(!minHeap.isEmpty() && visited.size()<n){
            int[] currPoint = minHeap.poll();
            int node = currPoint[0];
            int weight = currPoint[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            cost+=weight;
            List<int[]>neighbours = adjacencyList.get(node);
            for(int i=0;i<neighbours.size();i++){
                int currNode[] = neighbours.get(i);
                int y = currNode[0];
                int d = currNode[1];
                if(!visited.contains(y)){
                    minHeap.add(new int[]{y,d});
                }
            }
        }
        return cost;
    }
}