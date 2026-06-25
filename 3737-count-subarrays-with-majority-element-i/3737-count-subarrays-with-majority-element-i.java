class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target)
                    count++;
                if (count * 2 > (j - i + 1))
                    res++;
            }
        }
        return res;
    }
}

/*
1
12
122
1223
2
22
223
2
23
3
*/