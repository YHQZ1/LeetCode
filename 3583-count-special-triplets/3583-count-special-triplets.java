class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1_000_000_007;
        int max = 200000;

        int[] left = new int[max + 1];
        int[] right = new int[max + 1];

        for (int num : nums) {
            right[num]++;
        }

        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int target = nums[i] * 2;

            right[curr]--;

            long leftCount = (target <= max) ? left[target] : 0;
            long rightCount = (target <= max) ? right[target] : 0;

            result = (result + leftCount * rightCount) % mod;

            left[curr]++;
        }
        return (int) result;
    }
}