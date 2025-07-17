// class Solution {
//     public int findPeakElement(int[] nums) {
//         int max = nums[0], idx = 0;
//         for(int i=0; i<nums.length-1; i++){
//             boolean prev = nums[i] > nums[i-1];
//             boolean next = nums[i+1] < nums[i];
//             if(prev && next){
//                 max = Math.max(max, nums[i]);
//                 if(max == nums[i]) idx = i;
//             }
//         }
//         return idx;
//     }
// }

// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n = nums.length;
        
//         for (int i = 0; i < n; i++) {
//             boolean left = (i == 0) || (nums[i] > nums[i - 1]);
//             boolean right = (i == n - 1) || (nums[i] > nums[i + 1]);

//             if (left && right) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }


class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; 
    }
}
