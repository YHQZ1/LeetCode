class Solution {
    public int factorial(int num) {
        if (num == 0)
            return 1;
        if (num == 1)
            return 1;
        return num * factorial(num - 1);
    }

    public int trailingZeroes(int n) {
        int fact = factorial(n);
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}