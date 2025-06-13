class Solution {
    public int findIndex(int[] nums, int target, boolean findFirst){
        int left = 0, right = nums.length-1, index = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                index = mid;
                if (findFirst){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        int first, last;
        first = findIndex(nums, target, true);
        last = findIndex(nums, target, false);
        return new int[]{first, last}; 
    }
}