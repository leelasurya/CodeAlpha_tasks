public class Reservation {

    private String customerName;
    private Room room;
    private int numberOfDays;
    private double totalAmount;
    private boolean paymentCompleted;

    public Reservation(
            String customerName,
            Room room,
            int numberOfDays
    ) {

        this.customerName = customerName;
        this.room = room;
        this.numberOfDays = numberOfDays;

        totalAmount = room.getPrice() * numberOfDays;

        paymentCompleted = false;
    }

    public int getRoomNumber() {
        return room.getRoomNumber();
    }

    public void makePayment() {

        paymentCompleted = true;

        System.out.println(
                "Payment of $" + totalAmount +
                " completed successfully!"
        );
    }

    public void displayReservation() {

        System.out.println("\n===== BOOKING DETAILS =====");

        System.out.println(
                "Customer Name: " + customerName
        );

        System.out.println(
                "Room Number: " + room.getRoomNumber()
        );

        System.out.println(
                "Room Category: " + room.getCategory()
        );

        System.out.println(
                "Number of Days: " + numberOfDays
        );

        System.out.println(
                "Total Amount: $" + totalAmount
        );

        if (paymentCompleted) {
            System.out.println(
                    "Payment Status: Paid"
            );
        } else {
            System.out.println(
                    "Payment Status: Pending"
            );
        }
    }
}