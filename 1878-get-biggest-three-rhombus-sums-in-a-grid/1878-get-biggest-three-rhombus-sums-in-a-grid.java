class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Set<Integer> sums = new HashSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                sums.add(grid[r][c]);

                for (int k = 1;; k++) {

                    int bottom = r + 2 * k;
                    int left = c - k;
                    int right = c + k;

                    if (bottom >= m || left < 0 || right >= n)
                        break;

                    int sum = 0;

                    for (int i = 0; i < k; i++)
                        sum += grid[r + i][c + i];

                    for (int i = 0; i < k; i++)
                        sum += grid[r + k + i][c + k - i];

                    for (int i = 0; i < k; i++)
                        sum += grid[r + 2 * k - i][c - i];

                    for (int i = 0; i < k; i++)
                        sum += grid[r + k - i][c - k + i];

                    sums.add(sum);
                }
            }
        }

        List<Integer> list = new ArrayList<>(sums);
        Collections.sort(list, Collections.reverseOrder());

        int size = Math.min(3, list.size());
        int[] res = new int[size];

        for (int i = 0; i < size; i++)
            res[i] = list.get(i);

        return res;
    }
}