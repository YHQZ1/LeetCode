class Solution {
    public static int findDuplicate(int[] nums) {
        boolean[] check = new boolean[nums.length + 1];
        for (int a : nums) {
            if (check[a]) {
                return a;
            }
            check[a] = true;
        }
        return -1;
    }
}