class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder old = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                old.append(Character.toLowerCase(ch));
            }
        }

        String New = old.toString();
        String rev = old.reverse().toString();
        return New.equals(rev);
    }
}
