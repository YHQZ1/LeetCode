class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder prefix = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            int j = 0;
            while (j < Math.min(prefix.length(), curr.length()) && prefix.charAt(j) == curr.charAt(j)) {
                j++;
            }
            prefix.setLength(j);
        }
        return prefix.toString();
    }
}