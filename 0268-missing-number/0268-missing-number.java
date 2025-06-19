class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + 1;
            sum = sum + count;
        }

        int sumNumbers = 0;
        for (int i = 0; i < nums.length; i++) {
            sumNumbers += nums[i];
        }

        int missing;

        missing = sum - sumNumbers;

        return missing;
    }
}