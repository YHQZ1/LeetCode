class Solution {
    private int even(int n) {
        int sum = 0;
        int count = n;
        int i = 1;

        while (count > 0) {
            if (i % 2 == 0) {
                count--;
                sum += i;
            }
            i++;
        }
        return sum;
    }

    private int odd(int n) {
        int sum = 0;
        int count = n;
        int i = 1;

        while (count > 0) {
            if (i % 2 == 1) {
                count--;
                sum += i;
            }
            i++;
        }
        return sum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int gcdOfOddEvenSums(int n) {
        int e = even(n);
        int o = odd(n);

        return gcd(e, o);
    }
}