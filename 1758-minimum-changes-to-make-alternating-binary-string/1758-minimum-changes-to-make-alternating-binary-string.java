class Solution {
    public int minOperations(String s) {
        int mismatch = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') != (i % 2))
                mismatch++;
        }

        return Math.min(mismatch, s.length() - mismatch);
    }
}