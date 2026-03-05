class Solution {
    public int minOperations(String s) {
        int diff0 = 0, diff1 = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected0)
                diff0++;
            if (s.charAt(i) != expected1)
                diff1++;
        }
        return Math.min(diff0, diff1);
    }
}