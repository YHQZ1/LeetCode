class Solution {
    class Fenwick {
        int[] bit;

        Fenwick(int size) {
            bit = new int[size + 1];
        }

        void update(int idx, int delta) {
            while (idx < bit.length) {
                bit[idx] += delta;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] == target) ? 1 : -1;
        }

        int[] prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int OFFSET = nums.length + 1;

        Fenwick bit = new Fenwick(2 * nums.length + 5);

        bit.update(OFFSET, 1);

        long ans = 0;

        for (int i = 1; i < prefix.length; i++) {
            ans += bit.query(prefix[i] + OFFSET - 1);
            bit.update(prefix[i] + OFFSET, 1);
        }
        return ans;
    }
}