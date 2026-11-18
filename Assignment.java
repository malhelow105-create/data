// Roll Number: 202510178


import java.util.Scanner;

// Smart Restaurant menu
public class Assignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Price of the meal: ");
        double mealPrice = scanner.nextDouble();

        System.out.println("Number of drinks ordered: ");
        int drinks = scanner.nextInt();

        System.out.println("Are you a student? (true/false): ");
        boolean student = scanner.nextBoolean();

        System.out.println("Service rating (1 to 5): ");
        int rating = scanner.nextInt();

        // Check if rating is valid
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Service rating must be between 1 and 5!");
            return;
        }

        // Constants and calculations
        final double DRINK_PRICE = 15.50;
        double drinksCost = drinks * DRINK_PRICE;
        double subtotal = mealPrice + drinksCost;

        // Determine discount (Only one, highest wins if both apply)
        double discountAmount = 0.0;
        
        if (student && age >= 60) {
            // Both apply, choose the larger (Student is 10%, Senior is 5%)
            discountAmount = subtotal * 0.10;
        } else if (student) {
            discountAmount = subtotal * 0.10;
        } else if (age >= 60) {
            discountAmount = subtotal * 0.05;
        }

        // Tip rule: 10% tip if rating is 4 or 5
        double tipAmount = 0.0;
        if (rating == 4 || rating == 5) {
            tipAmount = subtotal * 0.10;
        }

        // Final bill calculation
        double finalBill = (subtotal - discountAmount) + tipAmount;
        int wholeAmount = (int) finalBill;

        // Required Receipt Layout
        System.out.println("\n========================================");
        System.out.println("           SMART RESTAURANT             ");
        System.out.println("========================================");
        System.out.println("Customer: " + name);
        System.out.println("Meal: $" + mealPrice);
        System.out.println("Drinks: $" + drinksCost);
        System.out.println("Discount: $" + discountAmount);
        System.out.println("Tip: $" + tipAmount);
        System.out.println("Final bill: $" + finalBill);
        System.out.println("Whole amount: $" + wholeAmount);
        System.out.println("========================================");
        System.out.println("======== Roll number: 202510178 ========");
        System.out.println("========================================");

        scanner.close();
    }
}