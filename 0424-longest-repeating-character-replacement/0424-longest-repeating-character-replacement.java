class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int[] freq = new int[26];

        int res = 0, maxFreq = 0;

        while (right < s.length()) {
            char curr = s.charAt(right);
            freq[curr - 'A']++;
            maxFreq = Math.max(maxFreq, freq[curr - 'A']);

            while (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}