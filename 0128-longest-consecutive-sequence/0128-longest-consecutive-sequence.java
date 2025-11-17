class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(!set.contains(num-1)){
                int len = 1;
                int curr = num+1;

                while(set.contains(curr)){
                    curr++;
                    len++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }
}