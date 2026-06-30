class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length())
            return list;

        int[] mp = new int[26];
        int[] ms = new int[26];

        for (int i = 0; i < p.length(); i++)
            mp[p.charAt(i) - 'a']++;

        for (int i = 0; i < p.length(); i++)
            ms[s.charAt(i) - 'a']++;

        if (Arrays.equals(mp, ms))
            list.add(0);

        int leave = 0, enter = p.length();

        while (enter < s.length()) {
            ms[s.charAt(leave) - 'a']--;
            ms[s.charAt(enter) - 'a']++;

            if (Arrays.equals(mp, ms))
                list.add(leave + 1);

            leave++;
            enter++;
        }

        return list;
    }
}