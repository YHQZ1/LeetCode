class Solution {
    public boolean hasAlternatingBits(int n) {
        StringBuilder binary = new StringBuilder();

        while (n > 0) {
            binary.append(n % 2);
            n = n / 2;
        }

        for (int i = 0; i < binary.length() - 1; i++) {
            if (binary.charAt(i) == binary.charAt(i + 1))
                return false;
        }
        return true;
    }
}