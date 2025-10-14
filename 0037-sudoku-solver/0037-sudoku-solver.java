class Solution {
    public boolean isSafe(char[][] board, int row, int col, char num) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }

        int srow = (row / 3) * 3;
        int scol = (col / 3) * 3;

        for (int i = srow; i < srow + 3; i++) {
            for (int j = scol; j < scol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    public boolean helper(char[][] board, int row, int col) {
        if (row == 9)
            return true;

        int nextRow = row, nextCol = col + 1;

        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') {
            return helper(board, nextRow, nextCol);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (helper(board, nextRow, nextCol))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}