class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1, right = Long.MAX_VALUE, result = right;

        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long sum = 0;

            for (int i = 0; i < workerTimes.length && sum < mountainHeight; i++) {
                long validation = (long) (Math.sqrt((double) mid / workerTimes[i] * 2 + 0.25) - 0.5);
                sum = sum + validation;
            }

            if (sum >= mountainHeight) {
                result = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return result;
    }
}