class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        int maxK = Math.min(m, n);

        for (int k = maxK; k >= 2; k--) {
            for (int r = 0; r + k <= m; r++) {
                for (int c = 0; c + k <= n; c++) {
                    if (isMagic(grid, row, col, diag1, diag2, r, c, k)) {
                        return k;
                    }
                }
            }
        }

        return 1;
    }

    private boolean isMagic(
            int[][] grid,
            int[][] row,
            int[][] col,
            int[][] diag1,
            int[][] diag2,
            int r,
            int c,
            int k) {
        int target = row[r][c + k] - row[r][c];

        for (int i = r; i < r + k; i++) {
            if (row[i][c + k] - row[i][c] != target) {
                return false;
            }
        }

        for (int j = c; j < c + k; j++) {
            if (col[r + k][j] - col[r][j] != target) {
                return false;
            }
        }

        if (diag1[r + k][c + k] - diag1[r][c] != target) {
            return false;
        }

        if (diag2[r + k][c] - diag2[r][c + k] != target) {
            return false;
        }

        return true;
    }
}
