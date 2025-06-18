class Solution {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int max = 0;
        for(int i=0; i<gain.length; i++){
            start = start + gain[i];
            max = Math.max(max, start);
        }
        return max;
    }
}