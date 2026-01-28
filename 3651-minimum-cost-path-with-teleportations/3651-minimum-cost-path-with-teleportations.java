class Solution {
    private static final int INF = 1_000_000_000;

    static class State {
        int i, j, t, cost;
        State(int i, int j, int t, int cost) {
            this.i = i;
            this.j = j;
            this.t = t;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{grid[i][j], i, j});
            }
        }
        cells.sort(Comparator.comparingInt(a -> a[0]));

        int[] ptr = new int[k + 1];

        PriorityQueue<State> pq =
            new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));

        dp[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int i = cur.i, j = cur.j, t = cur.t, cost = cur.cost;

            if (cost > dp[i][j][t]) continue;

            if (i == m - 1 && j == n - 1) {
                return cost;
            }

            if (i + 1 < m) {
                int nc = cost + grid[i + 1][j];
                if (nc < dp[i + 1][j][t]) {
                    dp[i + 1][j][t] = nc;
                    pq.offer(new State(i + 1, j, t, nc));
                }
            }

            if (j + 1 < n) {
                int nc = cost + grid[i][j + 1];
                if (nc < dp[i][j + 1][t]) {
                    dp[i][j + 1][t] = nc;
                    pq.offer(new State(i, j + 1, t, nc));
                }
            }

            if (t < k) {
                while (ptr[t] < cells.size() &&
                       cells.get(ptr[t])[0] <= grid[i][j]) {

                    int x = cells.get(ptr[t])[1];
                    int y = cells.get(ptr[t])[2];

                    if (dp[x][y][t + 1] > cost) {
                        dp[x][y][t + 1] = cost;
                        pq.offer(new State(x, y, t + 1, cost));
                    }

                    ptr[t]++;
                }
            }
        }

        return -1;
    }
}
