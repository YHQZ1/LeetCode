class Solution {
    private void backtrack(List<String> list, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        if (left < n)
            backtrack(list, left + 1, right, s + "(", n);
        if (right < left)
            backtrack(list, left, right + 1, s + ")", n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, 0, 0, "", n);
        return list;
    }
}