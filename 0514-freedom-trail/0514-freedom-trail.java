class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        Map<Character, List<Integer>> charToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            charToIndices.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }

        Map<String, Integer> memo = new HashMap<>();
        return dfs(ring, key, 0, 0, charToIndices, memo);
    }

    private int dfs(String ring, String key, int ringPos, int keyPos,
                    Map<Character, List<Integer>> charToIndices,
                    Map<String, Integer> memo) {

        if (keyPos == key.length()) return 0;

        String memoKey = ringPos + "," + keyPos;
        if (memo.containsKey(memoKey)) return memo.get(memoKey);

        char targetChar = key.charAt(keyPos);
        List<Integer> indices = charToIndices.get(targetChar);
        int n = ring.length();
        int minSteps = Integer.MAX_VALUE;

        for (int index : indices) {
            int diff = Math.abs(index - ringPos);
            int step = Math.min(diff, n - diff);
            int total = step + 1 + dfs(ring, key, index, keyPos + 1, charToIndices, memo);
            minSteps = Math.min(minSteps, total);
        }

        memo.put(memoKey, minSteps);
        return minSteps;
    }
}
