class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            char curr = num.charAt(i);

            if (curr == '?')
                leftQ++;
            else
                leftSum += curr - '0';
        }

        for (int i = n / 2; i < n; i++) {
            char curr = num.charAt(i);

            if (curr == '?')
                rightQ++;
            else
                rightSum += curr - '0';
        }

        if ((leftQ + rightQ) % 2 == 1)
            return true;

        int qDiff = leftQ - rightQ;
        int sumDiff = leftSum - rightSum;

        if (qDiff == 0)
            return sumDiff != 0;

        return sumDiff + 9 * qDiff / 2 != 0;
    }
}