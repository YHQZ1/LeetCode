class Solution {
    private boolean isOneMutationAway(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }

        return diff == 1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        if (!set.contains(endGene))
            return -1;

        q.offer(startGene);
        visited.add(startGene);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(endGene)) {
                    return steps;
                }
                for (String gene : set) {
                    if (!visited.contains(gene) && isOneMutationAway(curr, gene)) {
                        visited.add(gene);
                        q.offer(gene);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}