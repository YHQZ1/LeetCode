class Solution {
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int count = 0;

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }

        if (count == word.length()) return true;
        if (count == 0) return true;
        if (count == 1 && Character.isUpperCase(chars[0])) return true;

        return false;
    }
}
