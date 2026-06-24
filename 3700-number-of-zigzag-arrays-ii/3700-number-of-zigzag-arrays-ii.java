class Solution {
    private final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[][] L = new long[m][m];
        long[][] U = new long[m][m];

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                if (k < j) L[j][k] = 1;
                if (k > j) U[j][k] = 1;
            }
        }

        long[][] M = matMul(U, L, m);

        int steps = n - 1;
        int pairs = steps / 2;
        int remainder = steps % 2;

        long[][] Mp = matPow(M, pairs, m);

        long[] dp = new long[m];
        Arrays.fill(dp, 1L);

        dp = matVec(Mp, dp, m);

        if (remainder == 1) {
            dp = matVec(L, dp, m);
        }

        long res = 0;
        for (int j = 0; j < m; j++) {
            res = (res + dp[j]) % MOD;
        }

        return (int) ((res * 2) % MOD);
    }

    private long[][] matMul(long[][] A, long[][] B, int m) {
        long[][] C = new long[m][m];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < m; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < m; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[] matVec(long[][] A, long[] v, int m) {
        long[] res = new long[m];
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = 0; j < m; j++) {
                sum = (sum + A[i][j] * v[j]) % MOD;
            }
            res[i] = sum;
        }
        return res;
    }

    private long[][] matPow(long[][] A, long p, int m) {
        long[][] result = new long[m][m];
        for (int i = 0; i < m; i++) result[i][i] = 1;
        long[][] base = A;
        while (p > 0) {
            if ((p & 1) == 1) result = matMul(result, base, m);
            base = matMul(base, base, m);
            p >>= 1;
        }
        return result;
    }
}