import java.util.*;

class Fancy {

    private static final long MOD = 1_000_000_007;

    private ArrayList<Long> list;
    private long mul = 1;
    private long add = 0;

    public Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {
        long stored = ((val - add) % MOD + MOD) % MOD;
        stored = (stored * modInverse(mul)) % MOD;
        list.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;

        long val = list.get(idx);
        val = (val * mul + add) % MOD;

        return (int) val;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % MOD;

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}