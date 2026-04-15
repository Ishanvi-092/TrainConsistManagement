import java.util.*;
import java.util.stream.*;

class PassengerBogie {
    String type;     // Sleeper, AC Chair, First Class
    int capacity;    // seat capacity

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " | Capacity: " + capacity;
    }
}

public class TrainConsistManagement {

    public static void main(String[] args) {

        // Create dataset (large for benchmarking)
        List<PassengerBogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new PassengerBogie("Sleeper", (int)(Math.random() * 100)));
        }

        // ---------------- LOOP BASED FILTERING ----------------
        long startLoop = System.nanoTime();

        List<PassengerBogie> loopResult = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ---------------- STREAM BASED FILTERING ----------------
        long startStream = System.nanoTime();

        List<PassengerBogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ---------------- RESULTS ----------------
        System.out.println("Loop Result Count: " + loopResult.size());
        System.out.println("Stream Result Count: " + streamResult.size());

        System.out.println("\nLoop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        // Consistency Check
        if (loopResult.size() == streamResult.size()) {
            System.out.println("\nBoth approaches give SAME result");
        } else {
            System.out.println("\nResults DO NOT MATCH");
        }
    }
}