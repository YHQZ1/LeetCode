class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE, high = 0;

        for (int[] s : squares) {
            double y = s[1], l = s[2];
            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double target = totalArea / 2.0;

        for (int iter = 0; iter < 80; iter++) {
            double mid = (low + high) / 2.0;
            double below = areaBelow(mid, squares);

            if (below < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double areaBelow(double h, int[][] squares) {
        double area = 0;

        for (int[] s : squares) {
            double y = s[1], l = s[2];

            if (h <= y) {
                continue;
            } else if (h >= y + l) {
                area += l * l;
            } else {
                area += l * (h - y);
            }
        }

        return area;
    }
}
