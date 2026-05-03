class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        String doubled = s + s;

        int i = 0, j = s.length();

        while (i < j && j < doubled.length()) {
            if (doubled.substring(i, j).equals(goal))
                return true;
            i++;
            j++;
        }
        return false;
    }
}