// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {

    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    private String type;   // Cylindrical, Rectangular
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public void assignCargo(String cargo) {

        try {
            // Safety Rule:
            // Rectangular bogie should NOT carry Petroleum
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe assignment: Rectangular bogie cannot carry Petroleum"
                );
            }

            // If safe → assign cargo
            this.cargo = cargo;
            System.out.println("Cargo assigned successfully: " + cargo);

        } catch (CargoSafetyException e) {
            // Handle exception gracefully
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("Assignment attempt completed for bogie type: " + type);
        }
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Cargo: " + (cargo != null ? cargo : "None");
    }
}

// Main Application
public class TrainConsistManagement {

    public static void main(String[] args) {

        // Safe case
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");

        System.out.println(b1);

        System.out.println("--------------------------------");

        // Unsafe case
        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum"); // should fail

        System.out.println(b2);

        System.out.println("--------------------------------");

        // Program continues
        GoodsBogie b3 = new GoodsBogie("Rectangular");
        b3.assignCargo("Coal"); // valid

        System.out.println(b3);

        System.out.println("\nProgram continues safely...");
    }
}