class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                char item = board[i][j];
                if (set.contains(item))
                    return false;
                else if (item != '.')
                    set.add(item);
            }
        }

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                char item = board[j][i];
                if (set.contains(item))
                    return false;
                else if (item != '.')
                    set.add(item);
            }
        }

        int[][] starts = new int[][] {
                { 0, 0 }, { 0, 3 }, { 0, 6 },
                { 3, 0 }, { 3, 3 }, { 3, 6 },
                { 6, 0 }, { 6, 3 }, { 6, 6 }
        };

        for (int[] pair : starts) {
            int i = pair[0];
            int j = pair[1];

            HashSet<Character> set = new HashSet<>();
            for (int row = i; row < i + 3; row++) {
                for (int col = j; col < j + 3; col++) {
                    char item = board[row][col];

                    if (item == '.')
                        continue;

                    if (set.contains(item))
                        return false;

                    set.add(item);
                }
            }
        }
        return true;
    }
}