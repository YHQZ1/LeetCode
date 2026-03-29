class Solution {
    public boolean canBeEqual(String s1, String s2) {
        return match(s1.charAt(0), s1.charAt(2), s2.charAt(0), s2.charAt(2)) &&
                match(s1.charAt(1), s1.charAt(3), s2.charAt(1), s2.charAt(3));
    }

    private boolean match(char a1, char a2, char b1, char b2) {
        return (a1 == b1 && a2 == b2) || (a1 == b2 && a2 == b1);
    }
}