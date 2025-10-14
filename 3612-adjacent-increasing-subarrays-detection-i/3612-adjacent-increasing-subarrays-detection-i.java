class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int a = 0; a + 2 * k <= n; a++) {
            boolean firstInc = true, secondInc = true;

            for (int i = a; i < a + k - 1; i++) {
                if (nums.get(i) >= nums.get(i + 1)) {
                    firstInc = false;
                    break;
                }
            }

            for (int i = a + k; i < a + 2 * k - 1; i++) {
                if (nums.get(i) >= nums.get(i + 1)) {
                    secondInc = false;
                    break;
                }
            }

            if (firstInc && secondInc) return true;
        }

        return false;
    }
}
