class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[][] adjacencyMatrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            if (adjacencyMatrix[prerequisite][course] == 0) {
                indegree[course]++;
            }
            adjacencyMatrix[prerequisite][course] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int c = 0; c < numCourses; c++) {
            if (indegree[c] == 0) {
                queue.offer(c);
            }
        }

        int completedCourses = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++;

            for (int nextCourse = 0; nextCourse < numCourses; nextCourse++) {
                if (adjacencyMatrix[currentCourse][nextCourse] == 1) {
                    if (--indegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        return completedCourses == numCourses;
    }
}
