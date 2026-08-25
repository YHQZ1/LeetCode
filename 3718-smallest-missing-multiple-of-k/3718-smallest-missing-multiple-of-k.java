class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int curr = k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr) {
                curr += k;
            }
        }
        return curr;
    }
}