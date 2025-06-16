class Solution {
    public int maximumDifference(int[] nums) {
        int maxdiff=-1;

        for(int i=0; i<nums.length; i++){
            for(int j=1; j<nums.length; j++){
                if(i<j && nums[i]<nums[j]){
                    int diff = nums[j] - nums[i];
                    maxdiff = Math.max(diff, maxdiff);
                }
            }
        }
        return maxdiff;
    }
}