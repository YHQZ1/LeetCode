class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int visited = nums.length;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                visited = i;
                break;
            }
        }

        if(visited == nums.length) return true;

        for(int i=visited+1; i<nums.length; i++){
            if(nums[i] == nums[visited]){
                if(i - visited > k) visited = i;
                else return false;
            }
        }
        return true;
    }
}

/*
nums[dist] = 1 = fixed
dist = 0;
---
i=1
nums[1] != fixed
i++
---
i=2
nums[2] != fixed
i++
---
i=3
nums[3] != fixed
i++
---
nums[4] == fixed
if(dist - i >= k) dist = i
else return false;
i++ 
*/