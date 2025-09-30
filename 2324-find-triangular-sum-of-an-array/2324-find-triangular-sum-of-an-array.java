class Solution {
    public int[] next(int[] nums){
        int[] newNums = new int[nums.length-1];
        for(int i=0; i<newNums.length; i++){
            int newElement = (nums[i] + nums[i+1]) % 10;
            newNums[i] = newElement;
        }
        return newNums;
    }

    public int triangularSum(int[] nums) {
        int size = nums.length;
        if(size == 1) return nums[0];
        while(size > 1){
            nums = next(nums);
            size--;
        }
        return nums[0];
    }
}