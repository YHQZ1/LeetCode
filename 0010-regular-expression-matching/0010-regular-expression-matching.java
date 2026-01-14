class Solution {

    public boolean dfs(Boolean[][] memo, String s, String p, int i, int j) {
        if (memo[i][j] != null)
            return memo[i][j];

        if (i >= s.length() && j >= p.length())
            return memo[i][j] = true;

        if (j >= p.length())
            return memo[i][j] = false;

        boolean match = i < s.length() &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            memo[i][j] =
                dfs(memo, s, p, i, j + 2) ||   // skip "x*"
                (match && dfs(memo, s, p, i + 1, j)); // consume char
        } else {
            memo[i][j] = match && dfs(memo, s, p, i + 1, j + 1);
        }

        return memo[i][j];
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(memo, s, p, 0, 0);
    }
}
