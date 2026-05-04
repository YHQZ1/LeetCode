class Solution {
    private void reverse(int[][] matrix) {
        int left = 0, right = matrix.length - 1;

        while (left < right) {
            int[] temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;

            left++;
            right--;
        }
    }

    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    public void rotate(int[][] matrix) {
        reverse(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
}