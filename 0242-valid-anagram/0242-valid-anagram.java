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

        // for (int i = 0; i < t.length(); i++) {
        //     char curr = t.charAt(i);
        //     if (S.containsKey(curr)) {
        //         int count = S.get(curr) - 1;
        //         if (count == 0) {
        //             S.remove(curr);
        //         } else {
        //             S.put(curr, count);
        //         }
        //     } else {
        //         return false;
        //     }
        // }
        return S.equals(T);
    }
}