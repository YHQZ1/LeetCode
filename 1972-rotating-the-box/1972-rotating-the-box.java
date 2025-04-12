class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
    int m = boxGrid.length;
    int n = boxGrid[0].length;

    char [][] result = new char[n][m];
    for (int i = 0; i < m; ++i)
        for (int j = n - 1, k = n - 1; j >= 0; --j) {
            result[j][m - i - 1] = '.';
            if (boxGrid[i][j] != '.') {
                k = boxGrid[i][j] == '*' ? j : k;
                result[k--][m - i - 1] = boxGrid[i][j];
            }
        }
    return result;
}
}