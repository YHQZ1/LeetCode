class Solution {
    public boolean detectCapitalUse(String word) {
        boolean result = false;
        if (word.length() > 0 &&
                (word.equals(word.toUpperCase()) ||
                        word.equals(word.toLowerCase()) ||
                        (Character.isUpperCase(word.charAt(0))
                                && word.substring(1).equals(word.substring(1).toLowerCase())))) {
            result = true;
        }
        return result;
    }
}
