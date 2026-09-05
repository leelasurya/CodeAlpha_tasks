import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();

        rooms.add(
                new Room(
                        101,
                        "Standard",
                        1000
                )
        );

        rooms.add(
                new Room(
                        102,
                        "Standard",
                        1000
                )
        );

        rooms.add(
                new Room(
                        201,
                        "Deluxe",
                        2000
                )
        );

        rooms.add(
                new Room(
                        202,
                        "Deluxe",
                        2000
                )
        );

        rooms.add(
                new Room(
                        301,
                        "Suite",
                        5000
                )
        );

        int choice;

        do {

            System.out.println(
                    "\n===== HOTEL RESERVATION SYSTEM ====="
            );

            System.out.println(
                    "1. View Available Rooms"
            );

            System.out.println(
                    "2. Book a Room"
            );

            System.out.println(
                    "3. View Booking Details"
            );

            System.out.println(
                    "4. Cancel Reservation"
            );

            System.out.println(
                    "5. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println(
                            "\n===== AVAILABLE ROOMS ====="
                    );

                    for (Room room : rooms) {

                        if (room.isAvailable()) {
                            room.displayRoom();
                        }
                    }

                    break;

                case 2:

                    System.out.print(
                            "Enter your name: "
                    );

                    String name = scanner.nextLine();

                    System.out.print(
                            "Enter room number: "
                    );

                    int roomNumber =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter number of days: "
                    );

                    int days =
                            scanner.nextInt();

                    scanner.nextLine();

                    Room selectedRoom = null;

                    for (Room room : rooms) {

                        if (room.getRoomNumber()
                                == roomNumber
                                && room.isAvailable()) {

                            selectedRoom = room;
                            break;
                        }
                    }

                    if (selectedRoom == null) {

                        System.out.println(
                                "Room not available!"
                        );

                    } else {

                        selectedRoom.bookRoom();

                        Reservation reservation =
                                new Reservation(
                                        name,
                                        selectedRoom,
                                        days
                                );

                        reservations.add(
                                reservation
                        );

                        System.out.println(
                                "Room booked successfully!"
                        );

                        System.out.print(
                                "Do you want to make payment? (yes/no): "
                        );

                        String payment =
                                scanner.nextLine();

                        if (payment.equalsIgnoreCase(
                                "yes"
                        )) {

                            reservation.makePayment();
                        }

                        reservation.displayReservation();
                    }

                    break;

                case 3:

                    System.out.print(
                            "Enter room number: "
                    );

                    int bookingRoomNumber =
                            scanner.nextInt();

                    scanner.nextLine();

                    boolean found = false;

                    for (Reservation reservation
                            : reservations) {

                        if (reservation.getRoomNumber()
                                == bookingRoomNumber) {

                            reservation.displayReservation();

                            found = true;
                            break;
                        }
                    }

                    if (!found) {

                        System.out.println(
                                "No reservation found!"
                        );
                    }

                    break;

                case 4:

                    System.out.print(
                            "Enter room number to cancel: "
                    );

                    int cancelRoomNumber =
                            scanner.nextInt();

                    scanner.nextLine();

                    boolean cancelled = false;

                    for (Reservation reservation
                            : reservations) {

                        if (reservation.getRoomNumber()
                                == cancelRoomNumber) {

                            for (Room room : rooms) {

                                if (room.getRoomNumber()
                                        == cancelRoomNumber) {

                                    room.cancelRoom();

                                    reservations.remove(
                                            reservation
                                    );

                                    System.out.println(
                                            "Reservation cancelled successfully!"
                                    );

                                    cancelled = true;
                                    break;
                                }
                            }

                            break;
                        }
                    }

                    if (!cancelled) {

                        System.out.println(
                                "Reservation not found!"
                        );
                    }

                    break;

                case 5:

                    System.out.println(
                            "Thank you for using our Hotel Reservation System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }

        } while (choice != 5);

        scanner.close();
    }
}