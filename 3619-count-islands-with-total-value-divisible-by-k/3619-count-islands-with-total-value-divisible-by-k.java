class Solution {
    private long sum = 0;
    private void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;

        sum += grid[i][j];
        grid[i][j] = 0;

        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }

    public int countIslands(int[][] grid, int k) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    sum = 0;
                    dfs(i, j, grid);
                    if (sum % k == 0)
                        count++;
                }
            }
        }
        return count;
    }
}