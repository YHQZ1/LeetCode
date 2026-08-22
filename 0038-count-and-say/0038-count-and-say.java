class Solution {
    private String compress(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(count);
                result.append(s.charAt(i - 1));
                count = 1;
            }
        }

        return result.toString();
    }

    public String countAndSay(int n) {
        int i = 1;
        String s = "1";
        while (i < n) {
            s = compress(s);
            i++;
        }
        return s;
    }
}