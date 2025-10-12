class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for (int i = 0; i + 2 < rows; i++) {
            for (int j = 0; j + 2 < cols; j++) {
                if (isMagic(grid, i, j)) count++;
            }
        }
        return count;
    }
    
    private boolean isMagic(int[][] g, int r, int c) {
        boolean[] seen = new boolean[10];
        
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = g[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        int s1 = g[r][c] + g[r][c+1] + g[r][c+2];
        int s2 = g[r+1][c] + g[r+1][c+1] + g[r+1][c+2];
        int s3 = g[r+2][c] + g[r+2][c+1] + g[r+2][c+2];
        
        int col1 = g[r][c] + g[r+1][c] + g[r+2][c];
        int col2 = g[r][c+1] + g[r+1][c+1] + g[r+2][c+1];
        int col3 = g[r][c+2] + g[r+1][c+2] + g[r+2][c+2];
        
        int diag1 = g[r][c] + g[r+1][c+1] + g[r+2][c+2];
        int diag2 = g[r][c+2] + g[r+1][c+1] + g[r+2][c];
        
        return s1 == 15 && s2 == 15 && s3 == 15 &&
               col1 == 15 && col2 == 15 && col3 == 15 &&
               diag1 == 15 && diag2 == 15;
    }
}
