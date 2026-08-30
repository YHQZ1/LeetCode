class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return 1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        int left = Math.max(minIdx, maxIdx) + 1;
        int right = n - Math.min(minIdx, maxIdx);
        int both = Math.min(minIdx, maxIdx) + 1 + n - Math.max(maxIdx, minIdx);

        return Math.min(both, Math.min(left, right));
    }
}