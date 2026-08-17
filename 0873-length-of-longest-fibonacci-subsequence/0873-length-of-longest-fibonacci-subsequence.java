class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2;

                int prev = arr[j] - arr[i];
                Integer k = map.get(prev);

                if (k != null && k < i) {
                    dp[i][j] = dp[k][i] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res >= 3 ? res : 0;
    }
}