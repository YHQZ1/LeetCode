class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0)
                set.add(nums[i]);
        }

        int curr = k;

        while (set.contains(curr)) {
            curr += k;
        }
        return curr;
    }
}