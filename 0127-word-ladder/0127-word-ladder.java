import java.util.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                char[] chars = word.toCharArray();

                for (int pos = 0; pos < chars.length; pos++) {
                    char original = chars[pos];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original)
                            continue;

                        chars[pos] = c;
                        String nextWord = new String(chars);

                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }

                    chars[pos] = original;
                }
            }

            level++;
        }

        return 0;
    }
}
