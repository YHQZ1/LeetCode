class Solution {
    private int moves = 0;

    private int dfs(int i, int j, int[][] grid, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = grid[i][j] + Math.min(dfs(i + 1, j, grid, dp), dfs(i, j + 1, grid, dp));
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, grid, dp);
    }
}