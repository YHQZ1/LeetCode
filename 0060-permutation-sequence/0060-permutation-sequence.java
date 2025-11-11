class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++)
            fact[i] = fact[i - 1] * i;

        k--;
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int idx = k / fact[i];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k %= fact[i];
        }

        return sb.toString();
    }
}
