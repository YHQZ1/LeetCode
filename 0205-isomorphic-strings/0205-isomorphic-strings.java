class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mappedValues = new HashSet<>(); 

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!map.containsKey(original)) {
                if (mappedValues.contains(replacement)) return false;

                map.put(original, replacement);
                mappedValues.add(replacement);
            } else {
                char mapped = map.get(original);
                if (mapped != replacement) return false;
            }
        }

        return true;
    }
}
