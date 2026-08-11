class Solution {
    public int missingInteger(int[] nums) {
        if (nums.length == 1)
            return nums[0] + 1;
        
        int sum = nums[0] + 1;
        int curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                curr += nums[i];
                sum = Math.max(sum, curr);
            } else {
                break;
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        if (!set.contains(sum))
            return sum;

        while (set.contains(sum))
            sum++;

        return sum;
    }
}