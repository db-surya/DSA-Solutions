class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, char[][] grid){
        if(grid[i][j]=='0')
            return;
        grid[i][j]='0';
        if(i+1<grid.length) dfs(i+1,j,grid);
        if(i-1>=0) dfs(i-1,j,grid);
        if(j+1<grid[0].length) dfs(i,j+1,grid);
        if(j-1>=0) dfs(i,j-1,grid);
    }
}