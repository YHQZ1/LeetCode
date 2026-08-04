class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        List<Integer> list = new ArrayList<>();

        for (int i = smallest; i <= largest; i++) {
            if (!set.contains(i))
                list.add(i);
        }
        
        return list;
    }
}