class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0)
                nums[i] *= -1;
        }

        Arrays.sort(nums);

        int i = 0, j = n - 1, k = 0;

        while (i <= j && k < n) {
            if (k % 2 == 0)
                sorted[k] = nums[j--];
            else
                sorted[k] = nums[i++];
            k++;
        }

        long sum = 0;

        for (int l = 0; l < n; l++) {
            if (l % 2 == 0)
                sum += sorted[l] * sorted[l];
            else
                sum -= sorted[l] * sorted[l];
        }
        return sum;
    }
}