class Solution {
    private boolean isAway(String curr, String gene) {
        int diff = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != gene.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }
        return diff == 1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene))
            return 0;

        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        int steps = 0;

        if (!set.contains(endGene))
            return -1;

        queue.offer(startGene);
        visited.add(startGene);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endGene))
                    return steps;

                for (String gene : set) {
                    if (!visited.contains(gene) && isAway(curr, gene)) {
                        visited.add(gene);
                        queue.offer(gene);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}