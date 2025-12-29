class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        boolean inserted = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] > newInterval[0]) {
                list.add(i, new int[] { newInterval[0], newInterval[1] });
                inserted = true;
                break;
            }
        }

        if (!inserted) {
            list.add(new int[] { newInterval[0], newInterval[1] });
        }

        int[][] updated = list.toArray(new int[list.size()][]);

        List<int[]> merged = new ArrayList<>();

        int start = updated[0][0];
        int end = updated[0][1];

        for (int i = 1; i < updated.length; i++) {
            int currStart = updated[i][0];
            int currEnd = updated[i][1];

            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                merged.add(new int[] { start, end });
                start = currStart;
                end = currEnd;
            }
        }
        merged.add(new int[] { start, end });
        return merged.toArray(new int[merged.size()][]);

    }
}