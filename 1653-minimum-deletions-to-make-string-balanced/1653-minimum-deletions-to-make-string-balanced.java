class Solution {
    public int minimumDeletions(String s) {
        int[] dpA = new int[s.length()];
        int[] dpB = new int[s.length()];

        int countA = 0;
        int countB = 0;

        for (int i = 0; i < s.length(); i++) {
            dpB[i] = countB;
            if (s.charAt(i) == 'b')
                countB++;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            dpA[i] = countA;
            if (s.charAt(i) == 'a')
                countA++;
        }

        int min = s.length();

        for (int i = 0; i < s.length(); i++) {
            min = Math.min(min, dpA[i] + dpB[i]);
        }
        return min;
    }
}