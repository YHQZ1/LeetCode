class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int l = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                l = Math.max(l, nums[j]);
            }

            int r = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                r = Math.min(r, nums[j]);
            }

            if (l - r <= k)
                return i;
        }
        return -1;
    }
}