class Solution {
    public String longestPalindrome(String s) {

        if (s.length() <= 1)
            return s;

        String result = "";

        for (int i = 1; i < s.length(); i++) {

            int high = i;
            int low = i;

            while (s.charAt(high) == s.charAt(low)) {
                high++;
                low--;

                if (low == -1 || high == s.length())
                    break;
            }

            String palindrome = s.substring(low + 1, high);
            if (palindrome.length() > result.length())
                result = palindrome;

            high = i;
            low = i - 1;

            while (s.charAt(high) == s.charAt(low)) {
                high++;
                low--;

                if (low == -1 || high == s.length())
                    break;
            }

            palindrome = s.substring(low + 1, high);
            if (palindrome.length() > result.length())
                result = palindrome;
        }
        return result;
    }
}