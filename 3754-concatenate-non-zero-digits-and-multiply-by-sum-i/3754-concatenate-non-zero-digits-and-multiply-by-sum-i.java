class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        long sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            if (rem == 0) {
                num = num + rem;
                n = n / 10;
            } else {
                num = num * 10;
                num = num + rem;
                n = n / 10;
            }
        }

        long rev = 0;

        while (num > 0) {
            long rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }

        return rev * sum;
    }
}