class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> row1 = new HashSet<>();
        HashSet<Character> row2 = new HashSet<>();
        HashSet<Character> row3 = new HashSet<>();

        List<String> list = new ArrayList<>();

        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";

        for (int i = 0; i < r1.length(); i++) {
            row1.add(r1.charAt(i));
        }

        for (int i = 0; i < r2.length(); i++) {
            row2.add(r2.charAt(i));
        }

        for (int i = 0; i < r3.length(); i++) {
            row3.add(r3.charAt(i));
        }

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;

            for (int j = 0; j < curr.length(); j++) {
                char ch = Character.toLowerCase(curr.charAt(j));
                if (row1.contains(ch))
                    count1++;
                else if (row2.contains(ch))
                    count2++;
                else if (row3.contains(ch))
                    count3++;
            }

            if (count1 == curr.length() || count2 == curr.length() || count3 == curr.length())
                list.add(curr);
        }
        return list.toArray(new String[0]);
    }
}