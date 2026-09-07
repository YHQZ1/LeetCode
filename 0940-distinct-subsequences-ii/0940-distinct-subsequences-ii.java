class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] dp = new long[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            long total = 1;

            for (long count : dp) {
                total = (total + count) % MOD;
            }

            dp[index] = total;
        }

        long answer = 0;

        for (long count : dp) {
            answer = (answer + count) % MOD;
        }

        return (int) answer;
    }
}