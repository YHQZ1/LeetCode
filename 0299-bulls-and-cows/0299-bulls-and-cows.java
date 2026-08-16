class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int bulls = 0, cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char curr = secret.charAt(i);
            if (curr == guess.charAt(i))
                bulls++;
            else {
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char curr = guess.charAt(i);
            if (secret.charAt(i) == curr)
                continue;

            if (map.containsKey(curr) && map.get(curr) > 0) {
                cows++;
                map.put(curr, map.get(curr) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }
}