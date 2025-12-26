class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);

            map1.put(key, value);
        }

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            char value = s.charAt(i);

            map2.put(key, value);
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = map1.get(s.charAt(i));
            sb1.append(curr);
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = map2.get(t.charAt(i));
            sb2.append(curr);
        }

        return (sb1.toString().equals(t) && sb2.toString().equals(s));
    }
}