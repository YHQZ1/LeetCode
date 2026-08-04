class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
        }

        for (int i = smallest; i <= largest; i++) {
            if (!set.contains(i))
                list.add(i);
        }

        return list;
    }
}