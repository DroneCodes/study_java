package Array.leetcodeQuestions;

import java.util.TreeMap;

/**
 * This class is used to solve the problem of rearranging cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
 * The cards are represented as an integer array where each element is the value written on the card.
 */
public class HandOfStraight {

    /**
     * This method checks if it's possible to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
     * It uses a TreeMap to count the frequency of each card in the hand. The TreeMap automatically sorts the keys in ascending order.
     * Then, it iterates through the TreeMap. For each card, if it has a positive count, it decreases the count of it and the next groupSize - 1 consecutive cards by one.
     * If any of these cards does not have a positive count, it returns false. If it finishes the iteration without returning false, it returns true.
     *
     * @param hand The input integer array representing the cards. Each element is the value written on the card and its length is between 1 and 10^4.
     * @param groupSize The size of each group of cards. It is a positive integer and is less than or equal to the length of hand.
     * @return A boolean value indicating whether it's possible to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int card : hand) {
            counts.put(card, counts.getOrDefault(card, 0) + 1);
        }

        for (int card : counts.keySet()) {
            if (counts.get(card) > 0) {
                for (int i = groupSize - 1; i >= 0; --i) {
                    if (counts.getOrDefault(card + i, 0) < counts.get(card)) {
                        return false;
                    }
                    counts.put(card + i, counts.get(card + i) - counts.get(card));
                }
            }
        }

        return true;
    }
}