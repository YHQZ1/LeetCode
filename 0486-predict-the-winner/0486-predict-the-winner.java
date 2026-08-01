class Solution {
    private int helper(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];

        int takeLeft = nums[l] - helper(nums, l + 1, r);
        int takeRight = nums[r] - helper(nums, l, r - 1);

        return Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }
}