class Solution {
    private int format(int n) {
        int prod = 1;
        while (n > 0) {
            int rem = n % 10;
            prod = prod * rem;
            n /= 10;
        }
        return prod;
    }

    public int smallestNumber(int n, int t) {
        int m = format(n);
        while (m % t != 0) {
            n++;
            m = format(n);
        }
        return n;
    }
}