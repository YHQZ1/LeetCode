class Solution {
    public int countPartitions(int[] nums) {
        int count = 0;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i=0; i<prefix.length-1; i++){
            int diff = prefix[i] - (prefix[prefix.length-1] - prefix[i]);
            if(diff % 2 == 0) count++;
        }
        return count;
    }
}
/*
10, 10, 3, 7, 6
10, 20, 23, 30, 36
i=0
0,i <-> i+1, n-1 => i - (n-1 - i)
*/