class Solution {
    public long countCommas(long n) {
        long result = 0;

        if (n >= 1_000)
            result += n - 999;

        if (n >= 1_000_000)
            result += n - 999_999;

        if (n >= 1_000_000_000)
            result += n - 999_999_999;

        if (n >= 1_000_000_000_000L)
            result += n - 999_999_999_999L;

        if (n >= 1_000_000_000_000_000L)
            result += n - 999_999_999_999_999L;

        return result;
    }
}