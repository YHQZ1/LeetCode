class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] indices = new int[2];
        indices[0] = Integer.MAX_VALUE;
        indices[1] = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && mid < indices[0]) {
                indices[0] = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && mid > indices[1]) {
                indices[1] = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (indices[0] == Integer.MAX_VALUE && indices[1] == Integer.MIN_VALUE) {
            return new int[] { -1, -1 };
        }

        return indices;
    }
}