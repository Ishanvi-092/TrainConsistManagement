import java.util.*;

public class TrainConsistManagement {

    // Bubble Sort Method
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop for comparison
            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // Example input
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        System.out.println(Arrays.toString(capacities));

        // Call Bubble Sort
        bubbleSort(capacities);

        System.out.println("\nSorted Capacities (Ascending):");
        System.out.println(Arrays.toString(capacities));

        System.out.println("\nProgram continues...");
    }
}