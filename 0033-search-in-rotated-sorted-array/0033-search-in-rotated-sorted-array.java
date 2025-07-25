class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int rot = start;
        start = 0;
        end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int realMid = (mid + rot) % n;
            if (nums[realMid] == target) return realMid;
            if (nums[realMid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
