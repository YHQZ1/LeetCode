import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> points = new ArrayList<>();

        points.add(new int[] { 1, 0 });

        for (int[] r : restrictions) {
            points.add(new int[] { r[0], r[1] });
        }

        points.sort((a, b) -> Integer.compare(a[0], b[0]));

        if (points.get(points.size() - 1)[0] != n) {
            points.add(new int[] { n, n - 1 });
        }

        int m = points.size();

        for (int i = 1; i < m; i++) {
            int dist = points.get(i)[0] - points.get(i - 1)[0];

            points.get(i)[1] = Math.min(
                    points.get(i)[1],
                    points.get(i - 1)[1] + dist);
        }

        for (int i = m - 2; i >= 0; i--) {
            int dist = points.get(i + 1)[0] - points.get(i)[0];

            points.get(i)[1] = Math.min(
                    points.get(i)[1],
                    points.get(i + 1)[1] + dist);
        }

        int ans = 0;

        for (int i = 0; i < m - 1; i++) {
            int x1 = points.get(i)[0];
            int h1 = points.get(i)[1];

            int x2 = points.get(i + 1)[0];
            int h2 = points.get(i + 1)[1];

            int dist = x2 - x1;

            int peak = (h1 + h2 + dist) / 2;

            ans = Math.max(ans, peak);
        }

        return ans;
    }
}