class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;
        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Character, Integer> ms = new HashMap<>();

        for (int i = 0; i < p.length(); i++)
            mp.put(p.charAt(i), mp.getOrDefault(p.charAt(i), 0) + 1);

        for (int i = 0; i < p.length(); i++) {
            ms.put(s.charAt(i), ms.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (ms.equals(mp))
            list.add(0);

        int leave = 0, enter = p.length();

        while (enter < s.length()) {
            char left = s.charAt(leave);
            char right = s.charAt(enter);

            ms.put(left, ms.get(left) - 1);
            if (ms.get(left) == 0)
                ms.remove(left);

            ms.put(right, ms.getOrDefault(right, 0) + 1);

            if (ms.equals(mp))
                list.add(leave + 1);

            leave++;
            enter++;
        }
        return list;
    }
}