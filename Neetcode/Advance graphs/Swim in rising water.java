class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]>queue = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        queue.add(new int[]{grid[0][0],0,0});
        HashSet<String>visited = new HashSet<>();
        while(!queue.isEmpty()){
            int[]curr = queue.poll();
            int height = curr[0];
            int i = curr[1];
            int j = curr[2];
            if(i==m-1 && j==n-1){
                return Math.max(grid[i][j],height);
            }
            visited.add(i+" "+j);
            //top
            if(i-1>=0 && !visited.contains((i-1)+" "+j)){
                int max = Math.max(height, grid[i-1][j]);
                queue.add(new int[]{max,i-1,j});
            }
            //bottom
            if(i+1<m && !visited.contains((i+1)+" "+j)){
                int max = Math.max(height, grid[i+1][j]);
                queue.add(new int[]{max,i+1,j});
            }
            //left
            if(j-1>=0 && !visited.contains(i+" "+(j-1))){
                int max = Math.max(height, grid[i][j-1]);
                queue.add(new int[]{max,i,j-1});
            }
            //right
            if(j+1<n && !visited.contains(i+" "+(j+1))){
                int max = Math.max(height, grid[i][j+1]);
                queue.add(new int[]{max,i,j+1});
            }
        }
        return 0;
    }
}