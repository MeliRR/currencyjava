import java.util.Scanner;

public class CurrencyConverter {

    // Fixed exchange rates
    static double usdToEur = 0.92;
    static double usdToGbp = 0.79;
    static double usdToJpy = 151.5;
    static double usdToMxn = 17.1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("💱 Welcome to the Currency Converter!");

        boolean keepConverting = true;

        while (keepConverting) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Convert from USD to another currency");
            System.out.println("2. Convert to USD from another currency");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertFromUSD(scanner);
                    break;
                case 2:
                    convertToUSD(scanner);
                    break;
                case 3:
                    keepConverting = false;
                    System.out.println("Thank you for using the Currency Converter!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void convertFromUSD(Scanner scanner) {
        System.out.print("\nEnter amount in USD: ");
        double amount = scanner.nextDouble();

        System.out.print("Convert to (EUR, GBP, JPY, MXN): ");
        String toCurrency = scanner.next().toUpperCase();

        double result = 0;

        switch (toCurrency) {
            case "EUR":
                result = amount * usdToEur;
                break;
            case "GBP":
                result = amount * usdToGbp;
                break;
            case "JPY":
                result = amount * usdToJpy;
                break;
            case "MXN":
                result = amount * usdToMxn;
                break;
            default:
                System.out.println("Unsupported currency.");
                return;
        }

        System.out.printf("%.2f USD is %.2f %s\n", amount, result, toCurrency);
    }

    public static void convertToUSD(Scanner scanner) {
        System.out.print("\nEnter target currency (EUR, GBP, JPY, MXN): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        double result = 0;

        switch (fromCurrency) {
            case "EUR":
                result = amount / usdToEur;
                break;
            case "GBP":
                result = amount / usdToGbp;
                break;
            case "JPY":
                result = amount / usdToJpy;
                break;
            case "MXN":
                result = amount / usdToMxn;
                break;
            default:
                System.out.println("Unsupported currency.");
                return;
        }

        System.out.printf("%.2f %s is %.2f USD\n", amount, fromCurrency, result);
    }
}
