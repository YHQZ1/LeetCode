class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                int curr = Math.abs(sum - target);
                int closest = Math.abs(closestSum - target);

                if (curr < closest)
                    closestSum = sum;
                if (sum < target)
                    i++;
                else if (sum > target)
                    j--;
                else
                    return sum;
            }
        }
        return closestSum;
    }
}
