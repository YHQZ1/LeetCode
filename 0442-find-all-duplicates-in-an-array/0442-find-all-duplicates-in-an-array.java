class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int key : map.keySet()){
            if(map.get(key) > 1){
                result.add(key);
            }
        }
        return result;
    }
}