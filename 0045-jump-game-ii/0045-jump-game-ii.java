class Solution {
    public int jump(int[] nums) {
        int count = 0, last = 0, curr = 0;

        for(int i=0; i<nums.length-1; i++){
            last = Math.max(last, i + nums[i]);

            if(i == curr){
                count++;
                curr = last;
            }
        }
        return count;
    }
}