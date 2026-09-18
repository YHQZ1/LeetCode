class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int pos = (left + right) / 2;

            int row = pos / n;
            int col = pos % n;

            if (matrix[row][col] == target)
                return true;

            if (matrix[row][col] > target)
                right = pos - 1;
            else
                left = pos + 1;
        }
        return false;
    }
}