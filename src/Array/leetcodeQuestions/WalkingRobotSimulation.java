package Array.leetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a method to simulate the movement of a robot on an infinite XY-plane.
 * The robot can receive commands to move forward, turn left, or turn right, and it must avoid obstacles.
 */
public class WalkingRobotSimulation {

    /**
     * Simulates the movement of the robot and returns the maximum Euclidean distance squared
     * that the robot ever gets from the origin.
     *
     * @param commands an array of commands where:
     *                 -2 means turn left 90 degrees,
     *                 -1 means turn right 90 degrees,
     *                 1 <= k <= 9 means move forward k units.
     * @param obstacles a 2D array of obstacles where each obstacle is represented as [xi, yi].
     * @return the maximum Euclidean distance squared from the origin that the robot reaches.
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: north, east, south, west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, direction = 0;
        int maxDistanceSquared = 0;

        // Store obstacles in a set for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Process each command
        for (int command : commands) {
            if (command == -2) {
                // Turn left
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                // Turn right
                direction = (direction + 1) % 4;
            } else {
                // Move forward
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }

        return maxDistanceSquared;
    }
}