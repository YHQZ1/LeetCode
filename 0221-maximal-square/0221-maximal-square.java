class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1];
        int maxSide = 0;

        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    dp[r][c] = 1 + Math.min(
                        dp[r - 1][c],
                        Math.min(dp[r][c - 1], dp[r - 1][c - 1])
                    );
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
