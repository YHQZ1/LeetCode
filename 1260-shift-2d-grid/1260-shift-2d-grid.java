class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                res.get(i).add(0);
            }
        }

        int total = m * n;
        k %= total;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int oldIndex = i * n + j;
                int newIndex = (oldIndex + k) % total;
                int newRow = newIndex / n;
                int newCol = newIndex % n;

                res.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return res;
    }
}