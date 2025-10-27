class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        ArrayList<StringBuilder> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (sb.length() > 0) {
                    result.add(sb);
                    sb = new StringBuilder();
                }
            } else {
                sb.append(chars[i]);
            }
        }

        if (sb.length() > 0) result.add(sb);

        Collections.reverse(result);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            res.append(result.get(i));
            if (i != result.size() - 1) res.append(' ');
        }

        return res.toString();
    }
}
