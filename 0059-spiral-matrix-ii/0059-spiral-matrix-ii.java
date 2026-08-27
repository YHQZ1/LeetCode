class Solution {
    public int[][] generateMatrix(int n) {

        int[][] mat = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int i = 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                mat[top][col] = i;
                i++;
            }

            top++;

            for (int row = top; row <= bottom; row++) {
                mat[row][right] = i;
                i++;
            }

            right--;

            for (int col = right; col >= left; col--) {
                mat[bottom][col] = i;
                i++;
            }

            bottom--;

            for (int row = bottom; row >= top; row--) {
                mat[row][left] = i;
                i++;
            }

            left++;
        }
        
        return mat;
    }
}