class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;
        int MOD = 12345;

        int[] prefix = new int[size];
        int[] suffix = new int[size];
        int[][] result = new int[n][m];

        prefix[0] = 1;

        for (int i = 1; i < size; i++) {
            int r = (i - 1) / m;
            int c = (i - 1) % m;
            prefix[i] = (int) ((1L * prefix[i - 1] * grid[r][c]) % MOD);
        }

        suffix[size - 1] = 1;

        for (int i = size - 2; i >= 0; i--) {
            int r = (i + 1) / m;
            int c = (i + 1) % m;
            suffix[i] = (int) ((1L * suffix[i + 1] * grid[r][c]) % MOD);
        }

        for (int i = 0; i < size; i++) {
            int r = i / m;
            int c = i % m;
            result[r][c] = (int) ((1L * prefix[i] * suffix[i]) % MOD);
        }

        return result;
    }
}