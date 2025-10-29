class Solution {
    public int smallestNumber(int n) {
        int[] binary = {0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        int count = 0;

        for(int i=0; i<binary.length; i++){
            if(n < binary[i]) break;
            else count++;
        }
        return binary[count] - 1;
    }
}