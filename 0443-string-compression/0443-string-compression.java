class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int count = 1;

        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[write++] = chars[i - 1];

                if (count > 1) {
                    String countStr = Integer.toString(count);
                    for (char c : countStr.toCharArray()) {
                        chars[write++] = c;
                    }
                }

                count = 1;
            }
        }

        return write;
    }
}