class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mappedValues = new HashSet<>(); 

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!map.containsKey(original)) {
                if (!mappedValues.contains(replacement)) {
                    map.put(original, replacement);
                    mappedValues.add(replacement);
                } else {
                    return false; 
                }
            } else {
                char mapped = map.get(original);
                if (mapped != replacement) return false;
            }
        }

        return true;
    }
}
