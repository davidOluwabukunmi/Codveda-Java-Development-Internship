package Level2;

import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;
        boolean exit = false;

        System.out.println("Welcome to the Simple Banking Application!");

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Check if user entered a valid integer choice
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.printf("Your current balance is: $%.2f%n", balance);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: $");
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            if (depositAmount > 0) {
                                balance += depositAmount;
                                System.out.printf("Successfully deposited $%.2f. New balance: $%.2f%n", depositAmount, balance);
                            } else {
                                System.out.println("Deposit amount must be positive.");
                            }
                        } else {
                            System.out.println("Invalid amount. Please enter a valid number.");
                            scanner.next(); // Clear invalid amount token
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: $");
                        if (scanner.hasNextDouble()) {
                            double withdrawAmount = scanner.nextDouble();
                            if (withdrawAmount > 0) {
                                if (withdrawAmount <= balance) {
                                    balance -= withdrawAmount;
                                    System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f%n", withdrawAmount, balance);
                                } else {
                                    System.out.println("Insufficient balance for this withdrawal.");
                                }
                            } else {
                                System.out.println("Withdrawal amount must be positive.");
                            }
                        } else {
                            System.out.println("Invalid amount. Please enter a valid number.");
                            scanner.next(); // Clear invalid amount token
                        }
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using the Banking Application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                scanner.next(); // Clear invalid menu option token
            }
        }

        scanner.close();
    }
}
