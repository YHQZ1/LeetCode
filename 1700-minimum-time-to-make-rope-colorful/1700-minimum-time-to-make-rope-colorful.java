class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int maxTimeInGroup = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                totalTime += Math.min(maxTimeInGroup, neededTime[i]);
                maxTimeInGroup = Math.max(maxTimeInGroup, neededTime[i]);
            } else {
                maxTimeInGroup = neededTime[i];
            }
        }

        return totalTime;
    }
}
