class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean result = false;
        if(nums.length == 1) return true;
        for(int i=0; i<nums.length-1; i++){
            if((nums[i]%2 == 0 && nums[i+1]%2 == 1) || (nums[i]%2 == 1 && nums[i+1]%2 == 0)){
                result = true;
            } else {
                return false;
            }
        }
        return result;
    }
}