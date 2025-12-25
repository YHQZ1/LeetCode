class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char curr = ransomNote.charAt(i);
            if (!map.containsKey(curr))
                return false;

            map.put(curr, map.get(curr) - 1);
            
            if (map.get(curr) == 0) {
                map.remove(curr);
            }
        }
        return true;
    }
}