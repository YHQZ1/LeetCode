class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] prerequistNums = new int[numCourses];

        List<List<Integer>> prerequisiteList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            prerequisiteList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];

            prerequistNums[prerequisite[0]]++;

            List<Integer> preList = prerequisiteList.get(prerequisite[1]);
            if (preList == null) {
                preList = preList = new ArrayList<>();
            }
            preList.add(prerequisite[0]);
        }

        Queue<Integer> roots = new LinkedList<Integer>();
        int countCompleted = 0;
        for (int i = 0; i < numCourses; i++) {

            if (prerequistNums[i] == 0) {
                roots.add(i);

            }
        }

        while (roots.size() > 0) {
            Integer course = roots.poll();
            countCompleted++;
            List<Integer> preList = prerequisiteList.get(course);
            preList.forEach(dependent -> {
                prerequistNums[dependent]--;
                if (prerequistNums[dependent] == 0) {
                    roots.add(dependent);
                }
            });
        }

        return countCompleted == numCourses;
    }

}