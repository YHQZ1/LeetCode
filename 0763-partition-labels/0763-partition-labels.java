class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int maxReach = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            maxReach = Math.max(maxReach, last[s.charAt(i) - 'a']);
            if (i == maxReach) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
