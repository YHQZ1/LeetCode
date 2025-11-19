class Solution {
    public int findFinalValue(int[] nums, int original) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }

        while(list.contains(original)){
            original = original * 2;
        }
        return original;
    }
}