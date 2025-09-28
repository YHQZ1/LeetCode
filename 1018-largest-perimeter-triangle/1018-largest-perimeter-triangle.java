class Solution {
    public boolean isTriangle(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a)
            return true;
        return false;
    }

    public int largestPerimeter(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i], b = nums[i - 1], c = nums[i - 2];
            if (isTriangle(a, b, c)) {
                return a + b + c;
            }
        }
        return count;

    }
}