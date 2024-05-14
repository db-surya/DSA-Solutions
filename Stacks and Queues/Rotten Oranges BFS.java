class Cell{
    int row, col;
    Cell(int r,int c){
        this.row = r;
        this.col = c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        /*Iterate and find the count of fresh oranges 
        add rotten orange position into queue*/
        int freshOranges = 0;
        int rowDirections[] = new int[]{0,-1,0,1};
        int colDirections[] = new int[]{-1,0,1,0};
        Queue<Cell>queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    queue.add(new Cell(i,j));
                else if(grid[i][j]==1)
                    freshOranges++;
            }
        }
        //Breadth first search
        int hours = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Cell currCell = queue.remove();
                for(int k=0;k<4;k++){
                    int row = currCell.row + rowDirections[k];
                    int col = currCell.col + colDirections[k];
                    if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1){
                        freshOranges--;
                        grid[row][col]=2;
                        queue.add(new Cell(row,col));
                    }
                }
            }   
            /* 
                For first iteration count should not be added so we skip the count
                for last iteration
             */
            if(!queue.isEmpty()){
                hours++;
            } 
        }
        return freshOranges == 0 ? hours:-1;
    }
}