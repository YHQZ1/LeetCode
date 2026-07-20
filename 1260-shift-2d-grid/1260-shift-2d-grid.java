class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }

        k = k % list.size();

        Collections.reverse(list);
        Collections.reverse(list.subList(0, k));
        Collections.reverse(list.subList(k, list.size()));

        int r = 0;

        for (int i = 0; i < grid.length; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < grid[0].length; j++) {
                res.get(i).add(list.get(r));
                r++;
            }
        }

        return res;
    }
}