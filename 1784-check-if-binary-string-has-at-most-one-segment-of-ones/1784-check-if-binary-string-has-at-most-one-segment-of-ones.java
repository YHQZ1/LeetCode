class Solution {
    public boolean checkOnesSegment(String s) {
        boolean seenOne = false;
        boolean segmentEnded = false;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                if (segmentEnded) return false;
                seenOne = true;
            } else {
                if (seenOne) segmentEnded = true;
            }
        }

        return true;
    }
}