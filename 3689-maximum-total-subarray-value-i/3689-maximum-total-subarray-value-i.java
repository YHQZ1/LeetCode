class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > max) max = Math.max(nums[i], max);
            if(nums[i] < min) min = Math.min(nums[i], min);
        }

        return k * (max - min);
    }
}