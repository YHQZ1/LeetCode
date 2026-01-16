class Solution {
    static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] H = new int[hFences.length + 2];
        int[] V = new int[vFences.length + 2];

        H[0] = 1;
        H[1] = m;
        for (int i = 0; i < hFences.length; i++) {
            H[i + 2] = hFences[i];
        }

        V[0] = 1;
        V[1] = n;
        for (int i = 0; i < vFences.length; i++) {
            V[i + 2] = vFences[i];
        }

        Arrays.sort(H);
        Arrays.sort(V);

        Set<Integer> hDiffs = new HashSet<>();
        for (int i = 0; i < H.length; i++) {
            for (int j = i + 1; j < H.length; j++) {
                hDiffs.add(H[j] - H[i]);
            }
        }

        long maxSide = -1;

        for (int i = 0; i < V.length; i++) {
            for (int j = i + 1; j < V.length; j++) {
                int d = V[j] - V[i];
                if (hDiffs.contains(d)) {
                    maxSide = Math.max(maxSide, d);
                }
            }
        }

        if (maxSide == -1) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }
}
