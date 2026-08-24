class Solution {
    int[] dp;

    private int solve(int n) {
        if (n == 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];
        
        int max = 0;

        for (int i = 1; i < n; i++) {
            int product = Math.max(i * (n - i), i * solve(n - i));
            max = Math.max(max, product);
        }

        dp[n] = max;
        return max;
    }

    public int integerBreak(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n);
    }
}