class Solution {
    private boolean canBuild(int[][] prefix, int mid, int threshold, int m, int n) {
        for (int i = 0; i + mid <= m; i++) {
            for (int j = 0; j + mid <= n; j++) {
                int sum = prefix[i + mid][j + mid] - prefix[i][j + mid] - prefix[i + mid][j] + prefix[i][j];
                if (sum <= threshold)
                    return true;
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canBuild(prefix, mid, threshold, m, n)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}