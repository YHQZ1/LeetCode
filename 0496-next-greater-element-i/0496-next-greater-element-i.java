class Solution {
    private int nextGreater(int num, int[] nums, int idx) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > num && i > idx)
                return nums[i];
        }
        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            int value = nextGreater(nums2[i], nums2, i);

            map.put(key, value);
        }

        for (int i = 0; i < nums1.length; i++) {
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}