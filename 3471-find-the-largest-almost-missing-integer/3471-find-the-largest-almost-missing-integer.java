class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        int res = -1;

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        if (k == 1) {
            for (int num : nums) {
                if (map.get(num) == 1)
                    res = Math.max(res, num);
            }
        } else if (k == n) {
            for (int num : nums)
                res = Math.max(res, num);

        } else if (1 < k && k < n) {
            if (map.get(nums[0]) == 1)
                res = Math.max(res, nums[0]);

            if (map.get(nums[n - 1]) == 1)
                res = Math.max(res, nums[n - 1]);
        }
        return res;
    }
}