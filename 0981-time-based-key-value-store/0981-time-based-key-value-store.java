class TimeMap {

    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
            
        int left = 0;
        int right = map.get(key).size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (map.get(key).get(mid).timestamp <= timestamp) {
                res = map.get(key).get(mid).value;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return res;
    }
}