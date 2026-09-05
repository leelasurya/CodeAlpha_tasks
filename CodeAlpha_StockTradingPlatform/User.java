import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private double balance;
    private HashMap<String, Integer> portfolio;

    public User(String name, double balance) {

        this.name = name;
        this.balance = balance;
        this.portfolio = new HashMap<>();
    }

    public double getBalance() {
        return balance;
    }

    public void buyStock(Stock stock, int quantity) {

        double totalPrice = stock.getPrice() * quantity;

        if (totalPrice > balance) {

            System.out.println("Insufficient balance!");
            return;
        }

        balance -= totalPrice;

        portfolio.put(
            stock.getSymbol(),
            portfolio.getOrDefault(stock.getSymbol(), 0) + quantity
        );

        System.out.println(
            "Successfully bought " + quantity + " shares of "
            + stock.getSymbol()
        );
    }

    public void sellStock(Stock stock, int quantity) {

        String symbol = stock.getSymbol();

        if (!portfolio.containsKey(symbol)
                || portfolio.get(symbol) < quantity) {

            System.out.println(
                "You don't have enough shares to sell!"
            );

            return;
        }

        balance += stock.getPrice() * quantity;

        portfolio.put(
            symbol,
            portfolio.get(symbol) - quantity
        );

        if (portfolio.get(symbol) == 0) {
            portfolio.remove(symbol);
        }

        System.out.println(
            "Successfully sold " + quantity + " shares of "
            + symbol
        );
    }

    public void displayPortfolio() {

        System.out.println("\n===== YOUR PORTFOLIO =====");

        if (portfolio.isEmpty()) {
            System.out.println("Your portfolio is empty.");
        } else {

            for (Map.Entry<String, Integer> entry
                    : portfolio.entrySet()) {

                System.out.println(
                    entry.getKey()
                    + " : "
                    + entry.getValue()
                    + " shares"
                );
            }
        }
    }

    public void displayBalance() {

        System.out.printf(
            "\nAvailable Balance: $%.2f%n",
            balance
        );
    }
}