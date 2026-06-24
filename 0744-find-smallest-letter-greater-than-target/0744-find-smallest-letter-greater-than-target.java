class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target)
                return letters[i];
            else
                continue;
        }
        return letters[0];
    }
}

/*
97 - 122
arr = c, f, j -> 99, 102, 106 | t = 97

102 > 97
99 > 97
val = 99


*/