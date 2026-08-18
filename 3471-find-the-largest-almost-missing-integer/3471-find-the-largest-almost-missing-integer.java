class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (k == 1) {
            for (int num : nums) {
                if (map.get(num) == 1)
                    res = Math.max(res, num);
            }
        } else if (k == n) {
            for (int num : nums) {
                res = Math.max(res, num);
            }
        } else if (1 < k && k < n) {
            int first = nums[0];
            int last = nums[n - 1];
            if (map.get(first) == 1 && map.get(last) == 1)
                return Math.max(first, last);
            else if (map.get(first) > 1 && map.get(last) == 1)
                return last;
            else if (map.get(first) == 1 && map.get(last) > 1)
                return first;
            else if (map.get(first) > 1 && map.get(last) > 1)
                return -1;
        }
        return res;
    }
}