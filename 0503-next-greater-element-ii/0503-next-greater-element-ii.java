class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return new int[] { -1 };

        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!stack.isEmpty() && stack.peek() <= nums[idx])
                stack.pop();

            if (!stack.isEmpty())
                arr[idx] = stack.peek();
                
            stack.push(nums[idx]);
        }
        return arr;
    }
}