import java.util.*;

public class TrainConsistManagement {

    // Linear Search Method
    public static boolean linearSearch(String[] bogieIds, String key) {

        // Traverse array sequentially
        for (int i = 0; i < bogieIds.length; i++) {

            // Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // Match found → stop early
            }
        }

        return false; // No match found
    }

    public static void main(String[] args) {

        // Array of bogie IDs (unsorted)
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        // Search key
        String searchKey = "BG309";

        System.out.println("Bogie List: " + Arrays.toString(bogieIds));
        System.out.println("Searching for: " + searchKey);

        // Perform search
        boolean found = linearSearch(bogieIds, searchKey);

        // Display result
        if (found) {
            System.out.println("Bogie ID FOUND");
        } else {
            System.out.println("Bogie ID NOT FOUND");
        }

        System.out.println("\nProgram continues...");
    }
}