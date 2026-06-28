class Solution {
    private int solve(String s, int k) {
        if (s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        boolean good = true;

        for (int value : map.values()) {
            if (value < k) {
                good = false;
                break;
            }
        }

        if (good)
            return s.length();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.get(curr) < k) {
                int j = i;
                while(j < s.length() && map.get(s.charAt(j)) < k){
                    j++;
                }
                String left = s.substring(0, i);
                String right = s.substring(j, s.length());
                return Math.max(solve(left, k), solve(right, k));
            }
        }
        return 0;
    }

    public int longestSubstring(String s, int k) {
        return solve(s, k);
    }
}