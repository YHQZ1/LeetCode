class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {  // Only count even numbers
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                result = key;
            } else if (freq == maxFreq && key < result) {
                result = key;
            }
        }

        return result;
    }
}
