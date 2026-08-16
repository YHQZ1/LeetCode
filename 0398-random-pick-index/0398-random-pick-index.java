class Solution {
    private int[] arr;
    private Random random;

    public Solution(int[] nums) {
        arr = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int answer = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;

                if (random.nextInt(count) == 0) {
                    answer = i;
                }
            }
        }

        return answer;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */