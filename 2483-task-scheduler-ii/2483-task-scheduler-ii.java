class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long day = 0;

        for (int task : tasks) {
            if (map.containsKey(task) && day < map.get(task)) {
                day = map.get(task);
            }

            day++;
            map.put(task, day + space);
        }

        return day;
    }
}
