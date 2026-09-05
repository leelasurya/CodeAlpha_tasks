public class Room {

    private int roomNumber;
    private String category;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false;
    }

    public void cancelRoom() {
        isAvailable = true;
    }

    public void displayRoom() {

        String status;

        if (isAvailable) {
            status = "Available";
        } else {
            status = "Booked";
        }

        System.out.println(
                "Room No: " + roomNumber +
                " | Category: " + category +
                " | Price: $" + price +
                " | Status: " + status
        );
    }
}