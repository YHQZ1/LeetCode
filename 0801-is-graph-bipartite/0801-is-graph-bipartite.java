class Solution {
    public boolean dfs(int node, int[] color, int[][] graph) {
        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                color[neighbor] = 1 - color[node];
                if (!dfs(neighbor, color, graph)) return false;
            } else if (color[neighbor] == color[node]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!dfs(i, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
}
