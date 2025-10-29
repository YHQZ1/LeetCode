class Solution {
    public int smallestNumber(int n) {
        int num = n;
        while((num&(num+1)) != 0) num++;
        return num;
    }
}