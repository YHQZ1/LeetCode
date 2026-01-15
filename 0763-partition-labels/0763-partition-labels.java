class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        // Step 1: build frequency map
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Set<Character> active = new HashSet<>();
        int start = 0;

        // Step 2: process string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            active.add(c);
            freq.put(c, freq.get(c) - 1);

            if (freq.get(c) == 0) {
                active.remove(c);
            }

            // partition condition
            if (active.isEmpty()) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
