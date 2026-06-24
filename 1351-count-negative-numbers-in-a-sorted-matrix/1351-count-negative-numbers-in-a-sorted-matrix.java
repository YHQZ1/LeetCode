class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int r = 0, c = grid[0].length - 1;

        while (r < grid.length && c >= 0) {
            int total = grid.length;
            if (grid[r][c] < 0) {
                count = count + total - r;
                c--;
            } else {
                r++;
            }
        }
        return count;
    }
}