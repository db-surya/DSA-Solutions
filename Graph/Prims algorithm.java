class Solution{
    static class Pair{
        int weight;
        int node;
        Pair(int wt, int n){
            this.weight = wt;
            this.node = n;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    PriorityQueue<Pair>pq = new PriorityQueue<Pair>((x,y)->x.weight-y.weight);
	    Set<Integer>visited = new HashSet<>();
	    pq.add(new Pair(0,0));
	    int sum = 0;
	    while(!pq.isEmpty()){
	       Pair p  = pq.remove();
	       int currNode = p.node;
	       int currWeight  = p.weight;
	       if(visited.contains(currNode))continue;
	       //System.out.println(currNode+" "+currWeight);
	       visited.add(currNode);
	       sum+=currWeight;
	       for(int i=0;i<edges.length;i++){
	           //System.out.println("ok "+edges[i][0]);
	           if(edges[i][0]==currNode && !visited.contains(edges[i][1])){
	                pq.add(new Pair(edges[i][2],edges[i][1]));
	           }
	           else if(edges[i][1]==currNode && !visited.contains(edges[i][0])){
	                pq.add(new Pair(edges[i][2],edges[i][0]));
	           }
	       }
	    }
	   // System.out.println("Sum "+sum);
	    return sum;
	}
}