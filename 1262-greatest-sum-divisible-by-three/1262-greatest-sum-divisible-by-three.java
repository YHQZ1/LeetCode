class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;

        int rem1a = Integer.MAX_VALUE, rem1b = Integer.MAX_VALUE;
        int rem2a = Integer.MAX_VALUE, rem2b = Integer.MAX_VALUE;

        for (int num : nums) {
            total += num;
            int rem = num % 3;

            if (rem == 1) {
                if (num < rem1a) { rem1b = rem1a; rem1a = num; }
                else if (num < rem1b) { rem1b = num; }
            } else if (rem == 2) {
                if (num < rem2a) { rem2b = rem2a; rem2a = num; }
                else if (num < rem2b) { rem2b = num; }
            }
        }

        int rem = total % 3;

        if (rem == 1) {
            int op1 = rem1a < Integer.MAX_VALUE ? total - rem1a : Integer.MIN_VALUE;
            int op2 = rem2b < Integer.MAX_VALUE ? total - (rem2a + rem2b) : Integer.MIN_VALUE;
            return Math.max(op1, op2);
        }

        if (rem == 2) {
            int op1 = rem2a < Integer.MAX_VALUE ? total - rem2a : Integer.MIN_VALUE;
            int op2 = rem1b < Integer.MAX_VALUE ? total - (rem1a + rem1b) : Integer.MIN_VALUE;
            return Math.max(op1, op2);
        }

        return total;
    }
}
