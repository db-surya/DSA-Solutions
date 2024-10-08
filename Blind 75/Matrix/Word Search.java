class Solution {
    public boolean DFS(char[][] board, String word, int index, int i, int j){
        if(index == word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length 
        || board[i][j]!=word.charAt(index)) 
            return false;

        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = DFS(board, word, index+1,i+1,j) || 
                        DFS(board,word, index+1, i,j+1) || 
                        DFS(board, word, index+1, i, j-1) || 
                        DFS(board, word, index+1, i-1,j);
        board[i][j] = temp;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(DFS(board,word,0,i,j)) return true;
            }
        }   
        return false;
    }
}