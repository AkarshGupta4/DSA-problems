import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        int steps = 0;

        while (!num.equals(BigInteger.ONE)) {
            if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.valueOf(2));
            } else {
                num = num.add(BigInteger.ONE);
            }
            steps++;
        }

        return steps;
    }
}
