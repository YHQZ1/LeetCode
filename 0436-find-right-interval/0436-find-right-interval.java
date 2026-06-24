class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] temp = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            temp[i][0] = intervals[i][0];
            temp[i][1] = i;
        }

        Arrays.sort(temp, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            res[i] = -1;
            int target = intervals[i][1];
            int left = 0, right = temp.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (temp[mid][0] >= target) {
                    res[i] = temp[mid][1];
                    right = mid - 1;
                } else
                    left = mid + 1;
            }
        }
        return res;
    }
}