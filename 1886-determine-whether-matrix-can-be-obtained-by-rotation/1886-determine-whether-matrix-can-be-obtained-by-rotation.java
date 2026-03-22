class Solution {
    private void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    private boolean areEqual(int[][] A, int[][] B) {
        if (A.length != B.length)
            return false;
        if (A[0].length != B[0].length)
            return false;

        int rows = A.length;
        int cols = A[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 1; i <= 4; i++) {
            rotate(mat);
            if (areEqual(mat, target))
                return true;
        }
        return false;
    }
}