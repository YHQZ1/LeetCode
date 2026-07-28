class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < 26 && left.length() < s.length() / 2; i++) {
            char ch = (char) ('a' + i);
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append(ch);
            }
        }

        StringBuilder right = new StringBuilder(left);
        right.reverse();

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                char ch = (char) ('a' + i);
                left.append(ch);
                break;
            }
        }

        left.append(right);

        return left.toString();
    }
}