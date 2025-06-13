class Solution {
    public int searchIndex(int[] nums, int t, boolean find){
        int l = 0, r = nums.length-1, i = -1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] == t){
                i = m;
                if (find){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] < t){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return i;
    }

    public int[] searchRange(int[] nums, int target) {
        int fi, li;
        fi = searchIndex(nums, target, true);
        li = searchIndex(nums, target, false);
        return new int[]{fi, li}; 
    }
}