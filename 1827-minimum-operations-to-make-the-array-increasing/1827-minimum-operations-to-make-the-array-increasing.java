class Solution {
    public int minOperations(int[] nums) {
        int sum = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                sum = sum + nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i] + nums[i - 1] - nums[i] + 1;
            }
        }
        return sum;
    }
}