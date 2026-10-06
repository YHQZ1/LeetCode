class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int additions = 0;

        for (char curr : s.toCharArray()) {
            if (curr == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    additions++;
                }
            }
        }

        return additions + open;
    }
}