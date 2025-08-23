class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, sub = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                sub++;
                count = count + sub;
            } else {
                sub = 0;
            }
        }
        return count;
    }
}