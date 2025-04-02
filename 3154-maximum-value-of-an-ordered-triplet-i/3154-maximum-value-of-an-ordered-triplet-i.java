class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        int max1 = 0, max2 = 0;
        
        for (int num : nums) {
            res = Math.max(res, (long) max2 * num);
            max2 = Math.max(max2, max1 - num);
            max1 = Math.max(max1, num);
        }
        
        return res;
    }
}
