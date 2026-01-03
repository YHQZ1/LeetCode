class Solution {
    public int numOfWays(int n) {
        long mod = 1_000_000_007;

        long a = 6;
        long b = 6;

        for (int i = 1; i < n; i++) {
            long next_a = (3 * a + 2 * b) % mod;
            long next_b = (2 * a + 2 * b) % mod;

            a = next_a;
            b = next_b;
        }
        return (int)((a + b) % mod);
    }
}