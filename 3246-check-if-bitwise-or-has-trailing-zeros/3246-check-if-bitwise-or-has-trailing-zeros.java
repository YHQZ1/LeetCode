class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        boolean result;
        int count = 0;
      for(int i=0; i<nums.length; i++){
        if(nums[i]%2 == 0){
            count++;
        }
      }
      if(count>=2){
        result = true;
      } else {
        result = false;
      }
      return result;
    }
}