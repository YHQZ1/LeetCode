import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        int steps = 0;

        BigInteger ONE = BigInteger.ONE;
        BigInteger TWO = BigInteger.valueOf(2);

        while (!num.equals(ONE)) {
            if (num.mod(TWO).equals(BigInteger.ZERO)) {
                num = num.divide(TWO);
            } else {
                num = num.add(ONE);
            }
            steps++;
        }
        return steps;
    }
}