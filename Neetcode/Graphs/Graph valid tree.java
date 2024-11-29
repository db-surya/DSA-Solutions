class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Queue<int[]>queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(new int[]{0,-1});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int parent = curr[1];
            visited.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                int neighbor = adj.get(node).get(i);
                if(visited.contains(neighbor) && neighbor!=parent)
                    return false;
                if(!visited.contains(neighbor))
                queue.add(new int[]{neighbor, node});
            }
        }
        return visited.size()==n;
    }
}
