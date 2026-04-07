import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagement {

    static class Train {
        String trainId;
        String cargoCode;

        Train(String trainId, String cargoCode) {
            this.trainId = trainId;
            this.cargoCode = cargoCode;
        }

        public String toString() {
            return "TrainID: " + trainId + ", CargoCode: " + cargoCode;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" UC11 - Validate Train ID & Cargo ");
        System.out.println("==================================");

        List<Train> trains = new ArrayList<>();

        trains.add(new Train("TR1234", "CG-567"));
        trains.add(new Train("TR12", "CG-999"));
        trains.add(new Train("TR5678", "INVALID"));
        trains.add(new Train("TR0001", "CG-123"));

        System.out.println("All Trains:");
        trains.forEach(System.out::println);


        String trainPattern = "TR\\d{4}";     // TR followed by 4 digits
        String cargoPattern = "CG-\\d{3}";    // CG- followed by 3 digits

        System.out.println("\nValid Trains:");

        for (Train t : trains) {
            if (t.trainId.matches(trainPattern) &&
                    t.cargoCode.matches(cargoPattern)) {

                System.out.println(t);
            }
        }
    }
}