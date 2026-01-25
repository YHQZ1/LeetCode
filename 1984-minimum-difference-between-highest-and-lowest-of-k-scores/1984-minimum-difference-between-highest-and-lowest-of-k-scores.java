class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1)
            return 0;
        Arrays.sort(nums);
        int i = 0, j = k - 1;
        int min = Integer.MAX_VALUE;

        while (j < nums.length) {
            min = Math.min(nums[j] - nums[i], min);
            i++;
            j++;
        }
        return min;
    }
}

/*
1, 4, 7, 9
*/