class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int[] prefix = new int[nums.length];
            prefix[i] = nums[i];
            max = Math.max(max, prefix[i]);
            for(int j=i+1; j<nums.length; j++){
                prefix[j] = prefix[j-1] * nums[j];
                max = Math.max(max, prefix[j]);
            }
        }
        return max;
    }
}