class Solution {
    public int findComplement(int num) {
        int numberOfBits = Integer.toBinaryString(num).length();
        int bitMask = (1 << numberOfBits) - 1;

        return num ^ bitMask;
    }
}