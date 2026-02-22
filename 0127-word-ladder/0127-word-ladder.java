class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) return level;

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            queue.offer(next);
                            set.remove(next);
                        }
                    }

                    arr[j] = original;
                }
            }
            level++;
        }

        return 0;
    }
}