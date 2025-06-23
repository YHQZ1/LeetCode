class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() % k != 0) {
            sb.append(fill);
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < sb.length(); i += k) {
            result.add(sb.substring(i, i + k));
        }

        return result.toArray(new String[0]);
    }
}
