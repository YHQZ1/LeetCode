class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long placeValue = 1;

        while (placeValue <= n) {
            long lower = n % placeValue;
            long curr = (n / placeValue) % 10;
            long higher = n / (placeValue * 10);

            if (curr == 0) {
                count += higher * placeValue;
            } else if (curr == 1) {
                count += higher * placeValue + lower + 1;
            } else {
                count += (higher + 1) * placeValue;
            }

            placeValue *= 10;
        }

        return count;
    }
}
