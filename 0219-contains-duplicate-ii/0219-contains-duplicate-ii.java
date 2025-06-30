class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int j=0;
        int n=nums.length;

        for(int i=0; i<n; i++){
            while(set.contains(nums[i])){
                if(Math.abs(i - j) <= k) return true;
                set.remove(nums[j]);
                j++;
            }
            set.add(nums[i]);
        }
        return false;
    }
}