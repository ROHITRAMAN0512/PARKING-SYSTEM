import java.util.*;


// Main application class
public class ParkingLotApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;


        // Command loop for interactive input
        while (true) {
            System.out.print("$ ");
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "create_parking_lot":
                    int capacity = Integer.parseInt(tokens[1]);
                    parkingLot = new ParkingLot(capacity);
                    System.out.println("Created a parking lot with " + capacity + " slots");
                    break;

                case "park":
                    if (parkingLot != null) {
                        parkingLot.park(tokens[1], tokens[2]);
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;

                case "leave":
                    if (parkingLot != null) {
                        parkingLot.leave(Integer.parseInt(tokens[1]));
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;

                case "status":
                    if (parkingLot != null) {
                        parkingLot.status();
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;

                case "registration_numbers_for_cars_with_colour":
                    if (parkingLot != null) {
                        List<String> registrationNumbers = parkingLot.getRegistrationNumbersForColor(tokens[1]);
                        System.out.println(String.join(", ", registrationNumbers));
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;

                case "slot_number_for_registration_number":
                    if (parkingLot != null) {
                        int slotNumber = parkingLot.getSlotNumberForRegistration(tokens[1]);
                        if (slotNumber != -1) {
                            System.out.println(slotNumber);
                        } else {
                            System.out.println("Not found");
                        }
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;

                case "slot_numbers_for_cars_with_colour":
                    if (parkingLot != null) {
                        List<Integer> slotNumbers = parkingLot.getSlotNumbersForColor(tokens[1]);
                        if (!slotNumbers.isEmpty()) {
                            System.out.println(slotNumbers.stream()
                                    .map(String::valueOf)
                                    .collect(StringBuilder::new, (sb, s) -> sb.append(s).append(", "), StringBuilder::append)
                                    .toString().trim());
                        } else {
                            System.out.println("Not found");
                        }
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;

                case "exit":
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
