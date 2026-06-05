class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long[] freq = new long[31];

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            int bc = Integer.bitCount(num);
            freq[bc]++;
        }

        long count = 0;

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                if (i + j >= k) {
                    count += freq[i] * freq[j];
                }
            }
        }
        return count;
    }
}