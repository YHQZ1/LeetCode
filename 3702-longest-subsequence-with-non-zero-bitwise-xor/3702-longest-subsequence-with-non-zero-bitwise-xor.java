class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            if (nums[i] == 0)
                zeroes++;
        }

        if (xor != 0)
            return nums.length;
        if (xor == 0) {
            if (zeroes == nums.length)
                return 0;
        }
        return nums.length - 1;
    }
}