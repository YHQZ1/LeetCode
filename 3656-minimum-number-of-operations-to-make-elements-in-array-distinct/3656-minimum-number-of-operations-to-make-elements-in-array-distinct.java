class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        
        while (true) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;
            
            for (int num : list) {
                if (seen.contains(num)) {
                    hasDuplicate = true;
                    break;
                }
                seen.add(num);
            }

            if (!hasDuplicate) break; 
            
            int toRemove = Math.min(3, list.size());
            list.subList(0, toRemove).clear();
            ops++;
        }

        return ops;
    }
}