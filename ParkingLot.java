import java.util.*;

// Class representing the Parking Lot
class ParkingLot {
    private final int capacity;
    private final Map<Integer, String> slots;
    private final Map<String, Integer> registrationToSlot;
    private final Map<String, List<Integer>> colorToSlots;

    // Constructor to initialize the parking lot
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>();
        this.registrationToSlot = new HashMap<>();
        this.colorToSlots = new HashMap<>();
        initializeParkingLot();
    }

    // Initialize parking slots
    private void initializeParkingLot() {
        for (int i = 1; i <= capacity; i++) {
            slots.put(i, null);
        }
    }

    // Park a car in the parking lot
    public void park(String registrationNumber, String color) {
        if (isParkingLotFull()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }

        int availableSlot = findAvailableSlot();
        slots.put(availableSlot, registrationNumber);
        registrationToSlot.put(registrationNumber, availableSlot);

        colorToSlots.computeIfAbsent(color, k -> new ArrayList<>()).add(availableSlot);

        System.out.println("Allocated slot number: " + availableSlot);
    }

    // Remove a car from the parking lot
    public void leave(int slotNumber) {
        if (slots.containsKey(slotNumber) && slots.get(slotNumber) != null) {
            String registrationNumber = slots.get(slotNumber);
            slots.put(slotNumber, null);
            registrationToSlot.remove(registrationNumber);

            // Remove slot from colorToSlots
            for (List<Integer> slotsList : colorToSlots.values()) {
                slotsList.remove(Integer.valueOf(slotNumber));
            }

            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already empty");
        }
    }

    // Display the current status of the parking lot
    public void status() {
        System.out.println("Slot No. Registration No Colour");
        for (Map.Entry<Integer, String> entry : slots.entrySet()) {
            if (entry.getValue() != null) {
                String registrationNumber = entry.getValue();
                String color = getColorForRegistration(registrationNumber);
                System.out.println(entry.getKey() + " " + registrationNumber + " " + color);
            }
        }
    }

    // Get registration numbers of cars with a specific color
    public List<String> getRegistrationNumbersForColor(String color) {
        List<String> registrationNumbers = new ArrayList<>();
        if (colorToSlots.containsKey(color)) {
            List<Integer> slotsList = colorToSlots.get(color);
            for (int slotNumber : slotsList) {
                String registrationNumber = slots.get(slotNumber);
                registrationNumbers.add(registrationNumber);
            }
        }
        return registrationNumbers;
    }

    // Get slot number for a specific registration number
    public int getSlotNumberForRegistration(String registrationNumber) {
        return registrationToSlot.getOrDefault(registrationNumber, -1);
    }

    // Get slot numbers for cars with a specific color
    public List<Integer> getSlotNumbersForColor(String color) {
        return colorToSlots.getOrDefault(color, Collections.emptyList());
    }

    // Check if the parking lot is full
    private boolean isParkingLotFull() {
        return slots.values().stream().noneMatch(Objects::isNull);
    }

    // Find an available slot for parking
    private int findAvailableSlot() {
        for (int i = 1; i <= capacity; i++) {
            if (slots.get(i) == null) {
                return i;
            }
        }
        return -1; // Should not happen if the parking lot is checked to be full before calling this method.
    }

    // Get color for a specific registration number
    private String getColorForRegistration(String registrationNumber) {
        for (List<Integer> slotsList : colorToSlots.values()) {
            for (int slotNumber : slotsList) {
                if (registrationNumber.equals(slots.get(slotNumber))) {
                    return colorToSlots.entrySet().stream()
                            .filter(entry -> entry.getValue().contains(slotNumber))
                            .map(Map.Entry::getKey)
                            .findFirst()
                            .orElse(null);
                }
            }
        }
        return null;
    }
}