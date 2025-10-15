import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<long[]> left = new TreeSet<>(
                (a, b) -> a[0] != b[0] ? Long.compare(b[0], a[0]) : Long.compare(a[1], b[1]));
        TreeSet<long[]> right = new TreeSet<>(
                (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            long[] num = new long[] { nums[i], i };
            if (left.isEmpty() || num[0] <= left.first()[0])
                left.add(num);
            else
                right.add(num);

            if (i >= k) {
                long[] toRemove = new long[] { nums[i - k], i - k };
                if (left.contains(toRemove))
                    left.remove(toRemove);
                else
                    right.remove(toRemove);
            }

            while (left.size() > right.size() + 1)
                right.add(left.pollFirst());
            while (left.size() < right.size())
                left.add(right.pollFirst());

            if (i >= k - 1) {
                if (k % 2 == 0)
                    result[i - k + 1] = ((double) left.first()[0] + right.first()[0]) / 2.0;
                else
                    result[i - k + 1] = (double) left.first()[0];
            }
        }

        return result;
    }
}
