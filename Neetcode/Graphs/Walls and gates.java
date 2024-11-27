class Solution {
    public void findNearestTreasure(int distance, int i, int j, int[][] grid){
        if(grid[i][j]>distance) 
            grid[i][j] = distance;
        if(j-1>=0 && grid[i][j-1]>distance) 
            findNearestTreasure(distance+1,i,j-1,grid);
        if(i-1>=0 && grid[i-1][j]>distance) 
            findNearestTreasure(distance+1,i-1,j,grid);
        if(i+1<grid.length && grid[i+1][j]>distance) 
            findNearestTreasure(distance+1,i+1,j,grid);
        if(j+1<grid[0].length && grid[i][j+1]>distance) 
            findNearestTreasure(distance+1,i,j+1,grid);
    }
    public void islandsAndTreasure(int[][] grid) {
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==0){
                findNearestTreasure(0,i,j,grid);
            }
        }
       }
    }
}
