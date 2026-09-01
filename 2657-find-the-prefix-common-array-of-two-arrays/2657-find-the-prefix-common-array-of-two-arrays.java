class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int n = A.length;
        int[] C = new int[n];

        for (int i = 0; i < n; i++) {
            set.add(A[i]);
            int count = 0;
            for (int j = 0; j <= i; j++) {
                if (set.contains(B[j])) {
                    count++;
                }
            }
            C[i] = count;
        }
        return C;
    }
}