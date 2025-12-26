class Solution {
    public int countAliveNeighbors(int[][] board, int row, int col) {
        int alive = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0)
                    continue;

                int r = row + dr;
                int c = col + dc;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    if (board[r][c] == 1) {
                        alive++;
                    }
                }
            }
        }

        return alive;
    }

    public void gameOfLife(int[][] board) {
        int[][] updated = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cell = board[i][j];
                int neighbours = countAliveNeighbors(board, i, j);
                if (cell == 1) {
                    if (neighbours < 2)
                        updated[i][j] = 0;
                    else if (neighbours == 2 || neighbours == 3)
                        updated[i][j] = 1;
                    else if (neighbours > 3)
                        updated[i][j] = 0;
                } else if (cell == 0) {
                    if (neighbours == 3)
                        updated[i][j] = 1;
                    else
                        updated[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < updated.length; i++) {
            for (int j = 0; j < updated[0].length; j++) {
                board[i][j] = updated[i][j];
            }
        }
    }
}