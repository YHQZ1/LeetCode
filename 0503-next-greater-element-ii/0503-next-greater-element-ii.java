class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return new int[] { -1 };
            
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                if (nums[index] > nums[i]) {
                    arr[i] = nums[index];
                    break;
                } else {
                    arr[i] = -1;
                }
            }
        }
        return arr;
    }
}