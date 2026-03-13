class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1, right = Long.MAX_VALUE, answer = right;

        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long totalLayersRemoved = 0;

            for (int t : workerTimes) {
                if (totalLayersRemoved >= mountainHeight)
                    break;

                long layers = (long) (Math.sqrt((double) mid / t * 2 + 0.25) - 0.5);
                totalLayersRemoved += layers;
            }

            if (totalLayersRemoved >= mountainHeight) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}