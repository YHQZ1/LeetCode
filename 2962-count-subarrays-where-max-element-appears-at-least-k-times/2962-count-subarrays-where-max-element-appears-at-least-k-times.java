class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(num, max);
        }

        int left = 0;
        int count = 0;
        long res = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == max)
                count++;

            while (count >= k) {
                if (nums[left] == max)
                    count--;
                left++;
            }

            res += left;
        }
        return res;
    }
}