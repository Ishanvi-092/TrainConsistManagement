import java.util.Arrays;

public class TrainConsistManagement {

    public static void main(String[] args) {

        // Create array of bogie type names
        String[] bogieTypes = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieTypes));

        // Sort using built-in method
        Arrays.sort(bogieTypes);

        System.out.println("\nSorted Bogie Names (Alphabetical:");
        System.out.println(Arrays.toString(bogieTypes));

        System.out.println("\nProgram continues...");
    }
}