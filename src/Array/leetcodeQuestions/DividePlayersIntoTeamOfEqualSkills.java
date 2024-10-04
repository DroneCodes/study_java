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
        Arrays.sort(skill);
        int i=0;
        int j=skill.length-1;
        int sum=skill[i]+skill[j];
        long product=skill[i]*skill[j];
        i++;
        j--;
        while(i<j){
            if(sum!=skill[i]+skill[j]){
                return -1;
            }
            else{
                product+=skill[i]*skill[j];
                i++;
                j--;
            }
        }
        return product;
    }

    public static void main(String[] args) {
        DividePlayersIntoTeamOfEqualSkills solution = new DividePlayersIntoTeamOfEqualSkills();

        int[] skill1 = {3, 2, 5, 1, 3, 4};
        System.out.println(solution.dividePlayers(skill1)); // Output: 22

        int[] skill2 = {3, 4};
        System.out.println(solution.dividePlayers(skill2)); // Output: 12

        int[] skill3 = {1, 1, 2, 3};
        System.out.println(solution.dividePlayers(skill3)); // Output: -1
    }
}