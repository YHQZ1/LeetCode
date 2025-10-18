class Solution {
    public void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> result){
        path.add(node);

        if(node == graph.length-1){
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for(int neighbour : graph[node]){
            dfs(neighbour, graph, path, result);
        }

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0, graph, path, result);
        return result;
    }
}