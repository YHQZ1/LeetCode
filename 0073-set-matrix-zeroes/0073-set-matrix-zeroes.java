class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> flagRows = new HashSet<>();
        Set<Integer> flagCols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    flagRows.add(i);
                    flagCols.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (flagRows.contains(i) || flagCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}