class Solution {
    public int reverseDegree(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 26;
        char c = 'a';

        for (; j > 0; j--, c++) {
            map.put(c, j);
        }

        int degree = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int Sindex = i + 1;
            int Aindex = map.get(curr);
            int prod = Sindex * Aindex;

            degree += prod;
        }

        return degree;
    }
}