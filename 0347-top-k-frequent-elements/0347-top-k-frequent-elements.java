class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        ArrayList<Integer> list = new ArrayList<>();

        while (k > 0 && !pq.isEmpty()) {
            list.add(pq.poll().getKey());
            k--;
        }

        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
