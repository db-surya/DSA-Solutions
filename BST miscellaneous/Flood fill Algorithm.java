class Solution {
    public void dfs(int[][]image,int[][]copyImage, int sr, int sc, int[] rowDirections, int[] colDirections,int color, int initialColor){
        copyImage[sr][sc] = color;
        for(int i=0;i<4;i++){
            int row = sr + rowDirections[i];
            int col = sc + colDirections[i];
            int m = image.length;
            int n = image[0].length;
            if(row >= 0 && col >=0 && row<m && col<n && image[row][col]==initialColor && copyImage[row][col]!=color){
                dfs(image,copyImage,row,col,rowDirections,colDirections,color,initialColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int copyImage[][] = image;
        int[] rowDirections = new int[]{-1,0,1,0};
        int[] colDirections = new int[]{0,1,0,-1};
        dfs(image,copyImage,sr,sc,rowDirections,colDirections,color,initialColor);
        return image;
    }
}