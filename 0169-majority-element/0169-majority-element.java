class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int max = nums.length/2;

        for(int num : nums){
            numbers.put(num, numbers.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : numbers.entrySet()){
            if(entry.getValue() > max){
                return entry.getKey();
            }
        }
        return -1;
    }
}