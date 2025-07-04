class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleDigit = 0;
        int doubleDigit = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 10){
                singleDigit = singleDigit + nums[i];
            } else if(nums[i] >= 10){
                doubleDigit = doubleDigit + nums[i];
            }
        }
        if(singleDigit == doubleDigit) return false;
        return true;
    }
}