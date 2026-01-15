class Solution {
    public int maxGap(int[] bars) {
        if (bars.length == 0 || bars == null)
            return 1;

        Arrays.sort(bars);

        int max = 1;
        int curr = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] - bars[i - 1] == 1)
                curr++;
            else
                curr = 1;
            max = Math.max(max, curr);
        }
        return max + 1;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int height = maxGap(hBars);
        int width = maxGap(vBars);

        int maxSquare = Math.min(height, width);

        return maxSquare * maxSquare;
    }
}