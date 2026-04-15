import java.util.*;

public class TrainConsistManagement {

    // Search Method with Defensive Check
    public static boolean searchBogie(List<String> bogieIds, String key) {

        // 🔒 Defensive Programming Check
        if (bogieIds.isEmpty()) {
            throw new IllegalStateException("Cannot perform search: No bogies available in the train");
        }

        // Linear Search (can be replaced with binary if sorted)
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Case 1: Empty list (should throw exception)
        List<String> emptyList = new ArrayList<>();

        try {
            searchBogie(emptyList, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--------------------------------");

        // Case 2: Valid list
        List<String> bogieIds = Arrays.asList("BG101","BG205","BG309");

        try {
            boolean found = searchBogie(bogieIds, "BG205");

            if (found) {
                System.out.println("Bogie ID FOUND");
            } else {
                System.out.println("Bogie ID NOT FOUND");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}