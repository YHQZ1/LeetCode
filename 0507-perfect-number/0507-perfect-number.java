class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                int div = num / i;
                if (div != i) sum += div;
            }
        }
        return sum == num;
    }
}
