class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff)
                set.remove((long) nums[i - indexDiff - 1]);

            Long val = set.ceiling((long) nums[i] - valueDiff);

            if (val != null && val <= (long) nums[i] + valueDiff)
                return true;
                
            set.add((long) nums[i]);
        }
        return false;
    }
}