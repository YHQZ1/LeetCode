class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] > nums[right]) left = mid+1;
            else right = mid;
        }

        int pivot = left;
        left = 0;
        right = nums.length - 1;

        while(left <= right){
            int mid = left + (right-left)/2;
            int realMid = (mid + pivot) % nums.length;
            if(nums[realMid] == target) return realMid;
            else if(nums[realMid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}