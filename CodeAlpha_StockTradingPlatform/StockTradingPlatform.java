import java.util.ArrayList;
import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Stock> stocks = new ArrayList<>();

        stocks.add(
            new Stock(
                "AAPL",
                "Apple Inc.",
                180.50
            )
        );

        stocks.add(
            new Stock(
                "GOOGL",
                "Google",
                175.25
            )
        );

        stocks.add(
            new Stock(
                "MSFT",
                "Microsoft",
                420.75
            )
        );

        stocks.add(
            new Stock(
                "TSLA",
                "Tesla",
                250.00
            )
        );

        System.out.println(
            "===== STOCK TRADING PLATFORM ====="
        );

        System.out.print(
            "Enter your name: "
        );

        String name = scanner.nextLine();

        User user = new User(
            name,
            10000
        );

        int choice;

        do {

            System.out.println(
                "\n===== MENU ====="
            );

            System.out.println(
                "1. View Market Stocks"
            );

            System.out.println(
                "2. Buy Stock"
            );

            System.out.println(
                "3. Sell Stock"
            );

            System.out.println(
                "4. View Portfolio"
            );

            System.out.println(
                "5. View Balance"
            );

            System.out.println(
                "6. Exit"
            );

            System.out.print(
                "Enter your choice: "
            );

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println(
                        "\n===== MARKET STOCKS ====="
                    );

                    for (Stock stock : stocks) {
                        stock.displayStock();
                    }

                    break;

                case 2:

                    System.out.println(
                        "\nAvailable Stocks:"
                    );

                    for (int i = 0;
                         i < stocks.size();
                         i++) {

                        System.out.println(
                            (i + 1)
                            + ". "
                            + stocks.get(i).getSymbol()
                        );
                    }

                    System.out.print(
                        "Select stock number: "
                    );

                    int buyChoice =
                        scanner.nextInt();

                    if (buyChoice < 1
                            || buyChoice > stocks.size()) {

                        System.out.println(
                            "Invalid stock selection!"
                        );

                        break;
                    }

                    System.out.print(
                        "Enter quantity: "
                    );

                    int buyQuantity =
                        scanner.nextInt();

                    user.buyStock(
                        stocks.get(
                            buyChoice - 1
                        ),
                        buyQuantity
                    );

                    break;

                case 3:

                    System.out.println(
                        "\nAvailable Stocks:"
                    );

                    for (int i = 0;
                         i < stocks.size();
                         i++) {

                        System.out.println(
                            (i + 1)
                            + ". "
                            + stocks.get(i).getSymbol()
                        );
                    }

                    System.out.print(
                        "Select stock number: "
                    );

                    int sellChoice =
                        scanner.nextInt();

                    if (sellChoice < 1
                            || sellChoice > stocks.size()) {

                        System.out.println(
                            "Invalid stock selection!"
                        );

                        break;
                    }

                    System.out.print(
                        "Enter quantity: "
                    );

                    int sellQuantity =
                        scanner.nextInt();

                    user.sellStock(
                        stocks.get(
                            sellChoice - 1
                        ),
                        sellQuantity
                    );

                    break;

                case 4:

                    user.displayPortfolio();

                    break;

                case 5:

                    user.displayBalance();

                    break;

                case 6:

                    System.out.println(
                        "\nThank you for using the Stock Trading Platform!"
                    );

                    break;

                default:

                    System.out.println(
                        "Invalid choice!"
                    );
            }

        } while (choice != 6);

        scanner.close();
    }
}