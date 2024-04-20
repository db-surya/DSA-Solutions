class DisjointSet{
    int parent[], size[];
    DisjointSet(int V){
        parent = new int[V];
        size = new int[V];
        Arrays.fill(size,1);
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
    }
    public int findUltimateParent(int u){
        if(u==parent[u])return u;
        return parent[u] = findUltimateParent(parent[u]);
    }
    public void unionBySize(int u,int v){
        int ultU = findUltimateParent(u);
        int ultV = findUltimateParent(v);
        if(ultU==ultV)return;
        if(size[ultU]>size[ultV]){
            size[ultU]+=size[ultV];
            parent[ultV]=ultU;
        }
        else{
            size[ultV]+=size[ultU];
            parent[ultU]=ultV;
        }
    }
}
class Pair{
    int weight,u,v;
    Pair(int wt,int u,int v){
        this.weight = wt;
        this.u = u;
        this.v = v;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    DisjointSet ds = new DisjointSet(V);
	    PriorityQueue<Pair>pq = new PriorityQueue<>((x,y)->x.weight-y.weight);
	    for(int i=0;i<edges.length;i++){
	        pq.add(new Pair(edges[i][2],edges[i][0],edges[i][1]));
	    }
	    int mstWeight = 0;
	    while(!pq.isEmpty()){
	        Pair p = pq.remove();
	        int u = p.u;
	        int v = p.v;
	        int wt = p.weight;
	        int ultU = ds.findUltimateParent(u);
	        int ultV = ds.findUltimateParent(v);
	        if(ultU != ultV){
	            mstWeight+=wt;
	            ds.unionBySize(u,v);
	        }
	    }
	    return mstWeight;
	}
}