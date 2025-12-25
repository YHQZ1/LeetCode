class Solution {
    public void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        for(int i=0; i<matrix.length; i++){
            reverse(matrix[i]);
        }
    }
}

/*

[[1,2,3],[4,5,6],[7,8,9]]
[[1,4,7],[2,5,8],[3,6,9]]

0, 0 -> 0, 0
1, 0 -> 0, 1
2, 0 -> 0, 2

0, 1 -> 1, 0
1, 1 -> 1, 1
2, 1 -> 1, 2

0, 2 -> 2, 0
1, 2 -> 2, 1
2, 2 -> 2, 2

[[1,4,7],[2,5,8],[3,6,9]]
[[],[],[]]

j=0, k=
*/