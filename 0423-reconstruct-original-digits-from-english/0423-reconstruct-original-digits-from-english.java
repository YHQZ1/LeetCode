class Solution {
    public String originalDigits(String s) {
        int[] count = new int[26];
        int[] digits = new int[10];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        digits[0] = count['z' - 'a'];
        digits[2] = count['w' - 'a'];
        digits[4] = count['u' - 'a'];
        digits[6] = count['x' - 'a'];
        digits[8] = count['g' - 'a'];

        digits[1] = count['o' - 'a'] - digits[0] - digits[2] - digits[4];
        digits[3] = count['h' - 'a'] - digits[8];
        digits[5] = count['f' - 'a'] - digits[4];
        digits[7] = count['s' - 'a'] - digits[6];
        digits[9] = count['i' - 'a'] - digits[5] - digits[6] - digits[8];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digits[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}