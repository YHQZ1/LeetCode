class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points == null)
            return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int earliest = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (earliest < points[i][0]) {
                arrows++;
                earliest = points[i][1];
            }
        }
        return arrows;
    }
}