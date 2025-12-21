class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int water = Integer.MIN_VALUE;

        while (left < right) {
            int dist = right - left;
            water = Math.max(water, dist * Math.min(height[left], height[right]));
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return water;
    }
}