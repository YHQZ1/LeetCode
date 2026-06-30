class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int left = 0, right = 0;
        int[] freq = new int[3];
        while (right < s.length()) {
            char enter = s.charAt(right);
            if (enter == 'a')
                freq[0]++;
            else if (enter == 'b')
                freq[1]++;
            else if (enter == 'c')
                freq[2]++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - right;
                char leave = s.charAt(left);
                if (leave == 'a')
                    freq[0]--;
                else if (leave == 'b')
                    freq[1]--;
                else if (leave == 'c')
                    freq[2]--;

                left++;
            }
            right++;
        }
        return count;
    }
}