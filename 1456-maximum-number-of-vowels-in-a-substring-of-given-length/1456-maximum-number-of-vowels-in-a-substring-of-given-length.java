class Solution {
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        int curr = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                curr++;
        }

        max = curr;

        for (int i = k; i < s.length(); i++) {
            char enter = s.charAt(i);
            char leave = s.charAt(i - k);
            if (isVowel(enter))
                curr++;
            if (isVowel(leave))
                curr--;

            max = Math.max(max, curr);
        }
        return max;
    }
}