class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        //total courses and ans
        int totalCourses = 0;
        ArrayList<Integer>ans = new ArrayList<>();
        //add the nodes with indegree 0 in queue
        LinkedList<Integer>queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            System.out.println(indegree[i]);
            if(indegree[i]==0){
                queue.add(i);
                ans.add(i);
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
                    ans.add(child);
                }
            }
        }
        int[]ansArray = new int[ans.size()];
        if(ans.size()<numCourses)
            return new int[]{};
        for(int i=0;i<ans.size();i++){
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }
}
