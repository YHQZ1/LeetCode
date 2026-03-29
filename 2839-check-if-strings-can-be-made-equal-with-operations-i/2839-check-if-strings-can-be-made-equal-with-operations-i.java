class Solution {
    public void swapChars(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
            
        StringBuilder swap1 = new StringBuilder(s1);
        StringBuilder swap2 = new StringBuilder(s1);
        StringBuilder swap3 = new StringBuilder(s1);

        swapChars(swap1, 0, 2);
        swapChars(swap2, 1, 3);
        swapChars(swap3, 0, 2);
        swapChars(swap3, 1, 3);

        return s2.equals(swap1.toString()) || s2.equals(swap2.toString()) || s2.equals(swap3.toString());
    }
}