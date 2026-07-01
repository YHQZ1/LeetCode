class Solution {
    int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] d : dirs) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (dist[nr][nc] != -1)
                    continue;

                dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
                q.offer(new int[] { nr, nc });
            }
        }

        int low = 0;
        int high = 2 * (n - 1);
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int[][] dist, int limit) {
        int n = dist.length;

        if (dist[0][0] < limit)
            return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new int[] { 0, 0 });
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == n - 1 && curr[1] == n - 1)
                return true;

            for (int[] d : dirs) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (vis[nr][nc])
                    continue;

                if (dist[nr][nc] < limit)
                    continue;

                vis[nr][nc] = true;
                q.offer(new int[] { nr, nc });
            }
        }

        return false;
    }
}