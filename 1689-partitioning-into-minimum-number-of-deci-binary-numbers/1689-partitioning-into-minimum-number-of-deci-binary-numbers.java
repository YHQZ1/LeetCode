class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            char curr = n.charAt(i);

            max = Math.max(max, curr - '0');
        }
        return max;
    }
}