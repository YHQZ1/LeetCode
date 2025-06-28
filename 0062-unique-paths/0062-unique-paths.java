class Solution {
    public int count(int i, int j, int n, int m, int[][] dp) {
        if (i == n || j == m)
            return 0;
        if (i == n - 1 && j == m - 1)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];

        int right = count(i + 1, j, n, m, dp);
        int down = count(i, j + 1, n, m, dp);

        return dp[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return count(0, 0, n, m, dp);
    }
}
