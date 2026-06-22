class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> targetFreq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : target.toCharArray()) {
            targetFreq.put(ch, targetFreq.getOrDefault(ch, 0) + 1);
        }

        int answer = Integer.MAX_VALUE;

        for (char ch : targetFreq.keySet()) {
            int available = freq.getOrDefault(ch, 0);
            int required = targetFreq.get(ch);

            answer = Math.min(answer, available / required);
        }

        return answer;
    }
}