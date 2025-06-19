class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        int maxFreq = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 == 0){
                if(map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
                int freq = map.get(nums[i]);

                if(freq > maxFreq || freq == maxFreq && nums[i] < max){
                    max = nums[i];
                    maxFreq = freq;
                }
            }
        }
        return max;
    }
}