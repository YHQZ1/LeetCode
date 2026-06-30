class Solution {
    private boolean areEqual(String s1, String s2) {
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char curr1 = s1.charAt(i);
            char curr2 = s2.charAt(i);
            m1.put(curr1, m1.getOrDefault(curr1, 0) + 1);
            m2.put(curr2, m2.getOrDefault(curr2, 0) + 1);
        }

        return m1.equals(m2);
    }

    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            String subs = s2.substring(i, i + s1.length());
            if (areEqual(s1, subs))
                return true;
        }
        return false;
    }
}