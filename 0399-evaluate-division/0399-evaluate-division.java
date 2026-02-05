class Edge {
    String to;
    double weight;

    Edge(String to, double weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Edge(b, val));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Edge(a, 1.0 / val));
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            res[i] = bfs(graph, src, dst);
        }

        return res;
    }

    private double bfs(Map<String, List<Edge>> graph, String src, String dst) {
        if (!graph.containsKey(src) || !graph.containsKey(dst))
            return -1.0;

        Queue<Edge> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.add(new Edge(src, 1.0));
        visited.add(src);

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (cur.to.equals(dst)) {
                return cur.weight;
            }

            for (Edge next : graph.get(cur.to)) {
                if (!visited.contains(next.to)) {
                    visited.add(next.to);
                    q.add(new Edge(next.to, cur.weight * next.weight));
                }
            }
        }
        return -1.0;
    }
}
