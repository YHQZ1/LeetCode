class Solution {
    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0)
            return;
        else if (target == 0)
            list.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(list, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
}