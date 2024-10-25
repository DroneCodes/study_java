package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a method to remove all sub-folders from a given list of folders.
 * A sub-folder is defined as a folder that is located within another folder.
 */
public class RemoveSubFoldersFromTheFileSystem {

    /**
     * Removes all sub-folders from the given list of folders.
     *
     * @param folder an array of folder paths
     * @return a list of folder paths after removing all sub-folders
     */
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folders lexicographically
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String prev = "";

        // Iterate through the sorted list of folders
        for (String f : folder) {
            // Check if the current folder is not a sub-folder of the previous folder
            if (prev.isEmpty() || !f.startsWith(prev + "/")) {
                // Add the current folder to the result list
                result.add(f);
                // Update the previous folder to the current folder
                prev = f;
            }
        }

        // Return the list of folders after removing all sub-folders
        return result;
    }
}