class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int res = 0;

        int left = 0;
        int[] freq = new int[3];

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                res += n - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return res;
    }
}