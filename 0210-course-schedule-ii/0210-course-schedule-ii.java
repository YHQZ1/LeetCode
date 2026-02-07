class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] prerequisiteCount = new int[numCourses];
        List<List<Integer>> prerequisiteList = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            prerequisiteList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            prerequisiteCount[course]++;
            prerequisiteList.get(prerequisite).add(course);
        }

        Queue<Integer> roots = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (prerequisiteCount[i] == 0) {
                roots.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!roots.isEmpty()) {
            int course = roots.poll();
            order[index++] = course;

            for (int dependent : prerequisiteList.get(course)) {
                prerequisiteCount[dependent]--;
                if (prerequisiteCount[dependent] == 0) {
                    roots.add(dependent);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}
