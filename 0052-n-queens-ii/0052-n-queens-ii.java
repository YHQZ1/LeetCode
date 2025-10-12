class Solution {

    public boolean isSafe(int row, int col, char[][] board) {
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q')
                return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q')
                return false;
        }

        r = row;
        for (int c = col; c < board.length && r >= 0; c++, r--) {
            if (board[r][c] == 'Q')
                return false;
        }

        r = row;
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q')
                return false;
        }

        r = row;
        for (int c = col; c >= 0 && r < board.length; c--, r++) {
            if (board[r][c] == 'Q')
                return false;
        }

        return true;
    }

    public void helper(char[][] board, int col, int[] count) {
        if (col == board.length) {
            count[0]++;
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, col + 1, count);
                board[row][col] = '.';
            }
        }
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        int[] count = new int[1]; 
        helper(board, 0, count);
        return count[0];
    }
}
