class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for (int num : piles) {
            max = Math.max(num, max);
        }

        int left = 1, right = max, k = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                k = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return k;
    }
}