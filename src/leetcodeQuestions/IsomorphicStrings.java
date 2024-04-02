package leetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method to determine if two strings are isomorphic.
 * Two strings are isomorphic if the characters in the first string can be replaced to get the second string.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */
public class IsomorphicStrings {

    /**
     * This method determines if two strings are isomorphic.
     *
     * @param s The first string.
     * @param t The second string.
     * @return True if the strings are isomorphic, false otherwise.
     */

    /**
    The class `IsomorphicStrings` contains a method `isIsomorphic(String s, String t)`. This method is used to determine if two input strings, `s` and `t`, are isomorphic. Two strings are considered isomorphic if the characters in `s` can be replaced to get `t`, with the condition that all occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

    The method `isIsomorphic` uses two `HashMap` objects, `sToT` and `tToS`, to keep track of the character mappings between the two strings. The keys of `sToT` are characters from `s` and the values are the corresponding characters from `t`. Similarly, the keys of `tToS` are characters from `t` and the values are the corresponding characters from `s`.

    The method then iterates over the characters of both strings simultaneously using a for loop. For each pair of characters, it checks if a mapping already exists in either of the hash maps. If a mapping exists, it checks if it is consistent with the current pair of characters. If it is not, the method immediately returns `false`.

    If no mapping exists, it adds the new mapping to both hash maps.

    If the method finishes iterating over all the characters without finding any inconsistent mappings, it returns `true`, indicating that the two strings are isomorphic.

    In summary, this code provides a solution to determine if two strings are isomorphic by using two hash maps to keep track of the character mappings between the two strings.
    */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT.containsKey(sChar) && sToT.get(sChar) != tChar) {
                return false;
            }
            if (tToS.containsKey(tChar) && tToS.get(tChar) != sChar) {
                return false;
            }

            sToT.put(sChar, tChar);
            tToS.put(tChar, sChar);
        }

        return true;
    }
}