class Solution {
    class State {
        int score;
        int ways;

        State(int score, int ways) {
            this.score = score;
            this.ways = ways;
        }
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        State[][] dp = new State[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new State(-1, 0);
            }
        }

        dp[n - 1][n - 1] = new State(0, 1);

        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char curr = board.get(i).charAt(j);

                if (curr == 'X')
                    continue;

                if (i == n - 1 && j == n - 1)
                    continue;

                int bestScore = -1;
                int ways = 0;

                for (int[] d : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= n || nj >= n)
                        continue;

                    State next = dp[ni][nj];

                    if (next.score == -1)
                        continue;

                    if (next.score > bestScore) {
                        bestScore = next.score;
                        ways = next.ways;
                    } else if (next.score == bestScore) {
                        ways = (ways + next.ways) % MOD;
                    }
                }

                if (bestScore == -1)
                    continue;

                int val = 0;
                if (curr != 'E')
                    val = curr - '0';

                dp[i][j].score = bestScore + val;
                dp[i][j].ways = ways;
            }
        }

        if (dp[0][0].score == -1)
            return new int[] { 0, 0 };

        return new int[] { dp[0][0].score, dp[0][0].ways };
    }
}