class Solution {
    public int sum(int n) {
        int res = 0;
        while (n > 0) {
            int rem = n % 10;
            rem = rem * rem;
            res = res + rem;
            n = n / 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            n = sum(n);
            if (set.contains(n))
                return false;
            else
                set.add(n);
        }
        return true;
    }
}