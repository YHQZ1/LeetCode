class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int requirement = map.size();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char curr = s.charAt(right);

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) {
                    requirement--;
                }
            }

            right++;

            while (requirement == 0) {
                if (minLength > right - left) {
                    minLength = right - left;
                    start = left;
                }

                char shrink = s.charAt(left);

                if (map.containsKey(shrink)) {
                    map.put(shrink, map.get(shrink) + 1);
                    if (map.get(shrink) == 1) {
                        requirement++;
                    }
                }

                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}