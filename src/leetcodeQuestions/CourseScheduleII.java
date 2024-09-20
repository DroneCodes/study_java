package leetcodeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The `CourseScheduleII` class provides a method to find the order of courses to take to finish all courses.
 * It uses Kahn's algorithm (BFS) for topological sorting to determine the order.
 */
public class CourseScheduleII {

    /**
     * Finds the order of courses to take to finish all courses.
     *
     * The method works as follows:
     * 1. Represent the courses and their prerequisites as a directed graph.
     * 2. Maintain an array to keep track of the in-degrees of each node (course).
     * 3. Initialize a queue with all nodes that have an in-degree of 0 (courses with no prerequisites).
     * 4. Perform BFS. For each node, add it to the result list and reduce the in-degree of its neighbors by 1.
     *    If a neighbor's in-degree becomes 0, add it to the queue.
     * 5. If the result list contains all the courses, return it. Otherwise, return an empty array.
     *
     * @param numCourses The total number of courses.
     * @param prerequisites An array where each element is a pair [ai, bi] indicating that course bi must be taken before course ai.
     * @return The order of courses to take to finish all courses, or an empty array if it's impossible to finish all courses.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];

        // Initialize the graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph and fill the in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph[pre].add(course);
            inDegree[course]++;
        }

        // Initialize the queue with courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform BFS
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            for (int nextCourse : graph[course]) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        // Check if we were able to process all courses
        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}