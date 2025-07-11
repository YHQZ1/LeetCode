class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int first = coordinate1.charAt(0) - 'a' + coordinate1.charAt(1) - '0';
        int second = coordinate2.charAt(0) - 'a' + coordinate2.charAt(1) - '0'; 
        return first%2 == second%2;
    }
}