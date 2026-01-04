class Solution {
    public int sumFourDivisors(int[] nums) {
        int[] divisors = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int curr = nums[i];
            for (int j = 1; j <= curr; j++) {
                if (curr % j == 0)
                    count++;
            }
            divisors[i] = count;
        }
        int totalSum = 0;
        for (int i = 0; i < divisors.length; i++) {
            if (divisors[i] == 4) {
                int sum = 0;
                for (int j = 1; j <= nums[i]; j++) {
                    if (nums[i] % j == 0) {
                        sum = sum + j;
                    }
                }
                totalSum = sum + totalSum;
            }
        }
        return totalSum;
    }
}