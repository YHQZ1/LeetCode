class Solution {
    public String operation(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            int first = str.charAt(i) - '0';
            int second = str.charAt(i + 1) - '0';
            int sum = (first + second) % 10;
            sb.append(sum);
        }

        return sb.toString();
    }

    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            s = operation(s);
        }

        return s.length() == 2 && s.charAt(0) == s.charAt(1);
    }
}
