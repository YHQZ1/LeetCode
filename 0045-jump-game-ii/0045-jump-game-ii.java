class Solution {
    public int jump(int[] nums) {
        int count = 0, max = 0, curr = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == curr) {
                count++;
                curr = max;
            }
        }
        return count;
    }
}