class Solution {
    private String build(char start, int n) {
        StringBuilder sb = new StringBuilder(n);
        char curr = start;

        for (int i = 0; i < n; i++) {
            sb.append(curr);
            curr ^= 1;
        }

        return sb.toString();
    }

    public int minOperations(String s) {
        int size = s.length();

        String build1 = build('1', size);
        String build0 = build('0', size);

        int diff1 = 0, diff2 = 0;

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != build1.charAt(i))
                diff1++;
        }

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != build0.charAt(i))
                diff2++;
        }
        return Math.min(diff1, diff2);
    }
}