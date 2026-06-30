class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
            
        int[] mp = new int[26];
        int[] ms = new int[26];

        for (int i = 0; i < s1.length(); i++)
            mp[s1.charAt(i) - 'a']++;

        for (int i = 0; i < s1.length(); i++)
            ms[s2.charAt(i) - 'a']++;

        int leave = 0, enter = s1.length();

        if (Arrays.equals(mp, ms))
            return true;

        while (enter < s2.length()) {
            ms[s2.charAt(leave) - 'a']--;
            ms[s2.charAt(enter) - 'a']++;

            if (Arrays.equals(mp, ms))
                return true;

            leave++;
            enter++;
        }
        return false;
    }
}