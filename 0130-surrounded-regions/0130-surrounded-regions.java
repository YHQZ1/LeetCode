class Solution {
    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        int n = board.length;
        int m = board[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m)
            return;
        if (visited[i][j])
            return;
        if (board[i][j] == 'X')
            return;

        visited[i][j] = true;

        dfs(board, visited, i + 1, j);
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i, j + 1);
        dfs(board, visited, i, j - 1);
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && board[i][0] == 'O')
                dfs(board, visited, i, 0);
            if (!visited[i][m - 1] && board[i][m - 1] == 'O')
                dfs(board, visited, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            if (!visited[0][j] && board[0][j] == 'O')
                dfs(board, visited, 0, j);
            if (!visited[n - 1][j] && board[n - 1][j] == 'O')
                dfs(board, visited, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
}