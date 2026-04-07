import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainConsistManagement {

    static class Bogie {
        String trainName;
        int seats;

        Bogie(String trainName, int seats) {
            this.trainName = trainName;
            this.seats = seats;
        }

        public String toString() {
            return "Train: " + trainName + ", Seats: " + seats;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("==================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Train1", 72));
        bogies.add(new Bogie("Train1", 72));
        bogies.add(new Bogie("Train1", 72));
        bogies.add(new Bogie("Train2", 60));
        bogies.add(new Bogie("Train2", 60));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);


        Map<String, Integer> totalSeats = new HashMap<>();

        for (Bogie b : bogies) {
            totalSeats.put(b.trainName,
                    totalSeats.getOrDefault(b.trainName, 0) + b.seats);
        }

        System.out.println("\nTotal Seats per Train:");
        for (Map.Entry<String, Integer> entry : totalSeats.entrySet()) {
            System.out.println("Train: " + entry.getKey() +
                    ", Total Seats: " + entry.getValue());
        }
    }
}