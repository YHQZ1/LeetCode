class Solution {
    public int minSteps(int n) {
        int ops = 0;

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                ops += i;
                n /= i;
            }
        }
        return ops;
    }
}