class Solution {
    private static final long INF = (long) 1_000_000_000;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] == INF)
                    continue;
                for (int j = 0; j < 26; j++) {
                    if (dist[k][j] == INF)
                        continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';

            if (u == v)
                continue;

            if (dist[u][v] == INF)
                return -1;

            totalCost = totalCost + dist[u][v];
        }
        return totalCost;
    }
}

/*
source = abcd
target = acbe
original = [a, b, c, c, e, d]
changed = [b, c, b, e, b, e]
cost = [2, 5, 5, 1, 2, 20]

node = [(a, b, 2), (b, c, 5), (c, b, 5), (c, e, 1), (e, b, 2), (d, e, 20)]

cost = 0

s[i] == t[i] -> continue
else replace, cost updation

a, a -> continue
b, c -> node.source == b => node.target == c => 0 = 0 + 5 => cost = 5
c, b -> node.source == c => node.target == b => min([c, b], [c, e] + [e, b]) => 5 = 5 + 3 => cost = 8
d, e -> node.source == d => node.target == e => 8 = 8 + 20 => cost = 28

*/