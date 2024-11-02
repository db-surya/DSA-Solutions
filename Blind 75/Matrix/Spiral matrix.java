class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
        List<Integer> ans = new ArrayList<>();
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                ans.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    ans.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    ans.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return ans;
    }
}