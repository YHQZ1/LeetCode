class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        return !(nums.length == set.size());
    }
}

/*
nums.length = 4 => 0, 1, 2, 3
1, 2, 2, 2, 3 => (1, 2, 3)
----------------
1, 2, 3, 1
set = ()
(1)
(1, 2)
(1, 2, 3)
(1, 2, 3) = 3
nums[] = 4

3 == 4 -> !false

1==1 -> true
1!=1 -> false

!true = false
!false = true
*/