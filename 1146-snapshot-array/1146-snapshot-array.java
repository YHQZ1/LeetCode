class SnapshotArray {
    private final List<List<int[]>> history;
    private int snapId = 0;

    public SnapshotArray(int length) {
        history = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            history.add(new ArrayList<>());
            history.get(i).add(new int[] { 0, 0 });
        }
    }

    public void set(int index, int val) {
        List<int[]> h = history.get(index);
        if (h.get(h.size() - 1)[0] == snapId)
            h.get(h.size() - 1)[1] = val;
        else
            h.add(new int[] { snapId, val });
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> h = history.get(index);
        int left = 0, right = h.size() - 1, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (h.get(mid)[0] <= snap_id) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return h.get(res)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */