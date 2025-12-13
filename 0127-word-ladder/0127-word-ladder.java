import java.util.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) {
                    return level;
                }

                char[] word = curr.toCharArray();

                for (int c = 0; c < word.length; c++) {
                    char originalChar = word[c];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) {
                            continue;
                        }

                        word[c] = ch;
                        String next = new String(word);

                        if (set.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    word[c] = originalChar;
                }
            }

            level++;
        }

        return 0;
    }
}
