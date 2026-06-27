class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int res = 1;

        for (long num : map.keySet()) {
            if (num == 1) {
                int length = map.get(num);
                if (length % 2 == 0)
                    length--;
                res = Math.max(res, length);
                continue;
            }

            long curr = num;
            int chain = 0;

            while (map.containsKey(curr)) {
                long squared = curr * curr;
                if (map.get(curr) >= 2 && map.containsKey(squared)) {
                    chain += 2;
                    curr = squared;
                } else {
                    chain += 1;
                    break;
                }
            }
            res = Math.max(res, chain);
        }
        return res;
    }
}