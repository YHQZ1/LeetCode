class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int start = 0, end = n - 1;

        while (start < n && nums[start] == sorted[start]) {
            start++;
        }

        while (end >= 0 && nums[end] == sorted[end]) {
            end--;
        }

        if (start >= end)
            return 0;

        return end - start + 1;
    }
}