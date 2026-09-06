class Solution {
    private int[][] dp;
    private String s;
    private String t;

    private int generate(int i, int j) {
        if (j == t.length())
            return 1;

        if (i == s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) 
            return dp[i][j] = generate(i + 1, j + 1) + generate(i + 1, j);

        else 
            return dp[i][j] = generate(i+1, j);
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        this.dp = new int[n + 1][m + 1];
        this.s = s;
        this.t = t;

        for (int i = 0; i < n + 1; i++) 
            Arrays.fill(this.dp[i], -1);
        
        return generate(0, 0);
    }
}