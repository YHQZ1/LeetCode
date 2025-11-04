class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String fruit : words) {
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            return a.compareTo(b);
        });

        pq.addAll(map.keySet());

        while (k > 0) {
            result.add(pq.poll());
            k--;
        }
        return result;
    }
}