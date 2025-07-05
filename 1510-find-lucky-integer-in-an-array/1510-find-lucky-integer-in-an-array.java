class Solution {
    public int findLucky(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) == key) res = key;
        }
        return res;
    }
}