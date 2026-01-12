class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int currX = points[i][0];
            int currY = points[i][1];
            int nextX = points[i + 1][0];
            int nextY = points[i + 1][1];

            res = res + Math.max(Math.abs(nextX - currX), Math.abs(nextY - currY));
        }
        return res;
    }
}