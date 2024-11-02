class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        //Create adj list
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        //Compute indegree and also adj list
        int[]indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        //total courses 
        int totalCourses = 0;
        //add the nodes with indegree 0 in queue
        LinkedList<Integer>queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
                totalCourses++;
            }
        }
        //Start the bfs using kahn's algorithm
        while(!queue.isEmpty()){
            int parent = queue.remove();
            for(int i=0;i<adj.get(parent).size();i++){
                int child = adj.get(parent).get(i);
                indegree[child]--;
                if(indegree[child]==0){
                    queue.add(child);
                    totalCourses++;
                }
            }
        }
        return totalCourses == numCourses;
    }
}