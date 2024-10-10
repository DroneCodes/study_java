package Array.leetcodeQuestions;

import java.util.Arrays;

public class DividePlayersIntoTeamOfEqualSkills {
    /**
     * Divides players into teams such that each team has the same total skill and returns the sum of the chemistry of all teams.
     *
     * @param skill the array of player skills
     * @return the sum of the chemistry of all teams, or -1 if it's not possible to divide the players into valid teams
     */
    public long dividePlayers(int[] skill) {
        // Sort the array of player skills
        Arrays.sort(skill);
        int i = 0;
        int j = skill.length - 1;
        // Calculate the initial sum and product of the first and last player
        int sum = skill[i] + skill[j];
        long product = skill[i] * skill[j];
        i++;
        j--;
        // Iterate through the array to form teams
        while (i < j) {
            // Check if the current pair of players has the same total skill as the initial sum
            if (sum != skill[i] + skill[j]) {
                return -1; // Return -1 if it's not possible to form valid teams
            } else {
                // Add the product of the current pair of players to the total product
                product += skill[i] * skill[j];
                i++;
                j--;
            }
        }
        return product; // Return the total product (sum of the chemistry of all teams)
    }

    public static void main(String[] args) {
        DividePlayersIntoTeamOfEqualSkills solution = new DividePlayersIntoTeamOfEqualSkills();

        // Test case 1
        int[] skill1 = {3, 2, 5, 1, 3, 4};
        System.out.println(solution.dividePlayers(skill1)); // Output: 22

        // Test case 2
        int[] skill2 = {3, 4};
        System.out.println(solution.dividePlayers(skill2)); // Output: 12

        // Test case 3
        int[] skill3 = {1, 1, 2, 3};
        System.out.println(solution.dividePlayers(skill3)); // Output: -1
    }
}