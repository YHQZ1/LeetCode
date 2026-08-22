class Solution {
    private int sum(int n) {
        int res = 0;
        while (n != 0) {
            res = res + (n % 10);
            n = n / 10;
        }
        return res;
    }

    private int prod(int n) {
        int res = 1;
        while (n != 0) {
            res = res * (n % 10);
            n = n / 10;
        }
        return res;
    }

    public boolean checkDivisibility(int n) {
        return n % (sum(n) + prod(n)) == 0;
    }
}