class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x, sqrt = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == x/mid){
                return mid;
            } else if (mid > x / mid){
                right = mid - 1;
            } else {
                left = mid + 1;
                sqrt = mid;
            }
        }
        return sqrt;
    }
}