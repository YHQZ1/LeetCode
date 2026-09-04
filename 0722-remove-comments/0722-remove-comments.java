class Solution {
    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inBlockComment = false;

        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);

                if (!inBlockComment && i + 1 < s.length()
                        && curr == '/' && s.charAt(i + 1) == '/') {
                    break;
                }

                if (!inBlockComment && i + 1 < s.length()
                        && curr == '/' && s.charAt(i + 1) == '*') {
                    inBlockComment = true;
                    i++;
                } else if (inBlockComment && i + 1 < s.length()
                        && curr == '*' && s.charAt(i + 1) == '/') {
                    inBlockComment = false;
                    i++;
                } else if (!inBlockComment) {
                    sb.append(curr);
                }
            }

            if (!inBlockComment && sb.length() > 0) {
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        return list;
    }
}