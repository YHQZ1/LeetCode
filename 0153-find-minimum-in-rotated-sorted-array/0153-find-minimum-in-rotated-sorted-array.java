class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        Arrays.sort(nums);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(nums[mid]);
            if(nums[mid] <= min){
                min = nums[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}