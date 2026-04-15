import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    String type;   // Cylindrical, Rectangular, Open, Box
    String cargo;  // Petroleum, Coal, Grain, etc.

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Cargo: " + cargo;
    }
}

public class TrainConsistManagement {

    public static void main(String[] args) {

        // Create list of goods bogies
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Open", "Grain"),
                new GoodsBogie("Cylindrical", "Petroleum")
        );

        // Convert to stream and validate safety
        boolean isSafe = bogies.stream()
                .allMatch(bogie ->
                        // Rule: Cylindrical → only Petroleum
                        !bogie.getType().equalsIgnoreCase("Cylindrical") ||
                                bogie.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Display bogies
        System.out.println("Train Bogies:");
        bogies.forEach(System.out::println);

        // Display result
        if (isSafe) {
            System.out.println("\nTrain formation is SAFE");
        } else {
            System.out.println("\nTrain formation is NOT SAFE");
        }
    }
}