class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0 = false;
        //Check for the first row
        for(int j=0;j<col;j++)
        {
            if(matrix[0][j]==0)
            {
                row0 = true;
                break;
            }
        }
        //check for the entire matrix from second row and first column
        for(int i=1;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //Make zeroes for the entire matrix
        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                matrix[i][j]=0;
            }
        }
        //Make the first col as zeroes
        if(matrix[0][0]==0)
        {
            for(int i=0;i<row;i++)
            {
                matrix[i][0]=0;
            }
        }
        //Make the first row as zeroes
        if(row0)
        {
            for(int j=0;j<col;j++)
            {
                matrix[0][j]=0;
            }
        }
    }
}