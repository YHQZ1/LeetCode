class Solution {
    public int find(Map<Integer, Integer> parent, int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent, parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(Map<Integer, Integer> parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb)
            parent.put(pa, pb);
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        boolean[] know = new boolean[n];
        know[0] = true;
        know[firstPerson] = true;

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            Map<Integer, Integer> parent = new HashMap<>();

            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                parent.putIfAbsent(x, x);
                parent.putIfAbsent(y, y);

                union(parent, x, y);
                i++;
            }

            Map<Integer, Boolean> good = new HashMap<>();
            for (int p : parent.keySet()) {
                int root = find(parent, p);
                if (know[p]) {
                    good.put(root, true);
                }
            }

            for (int p : parent.keySet()) {
                int root = find(parent, p);
                if (good.getOrDefault(root, false)) {
                    know[p] = true;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (know[p])
                res.add(p);
        }
        return res;
    }
}