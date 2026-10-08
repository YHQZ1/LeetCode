class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for (char curr : s.toCharArray()) {

            if (curr == '(') {
                depth++;

                if (depth > 1) {
                    sb.append(curr);
                }

            } else {
                depth--;

                if (depth > 0) {
                    sb.append(curr);
                }
            }
        }
        return sb.toString();
    }
}