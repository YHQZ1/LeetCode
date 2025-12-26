class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> S = new HashMap<>();
        HashMap<Character, Integer> T = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            S.put(s.charAt(i), S.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            T.put(t.charAt(i), T.getOrDefault(t.charAt(i), 0) + 1);
        }

        return S.equals(T);
    }
}