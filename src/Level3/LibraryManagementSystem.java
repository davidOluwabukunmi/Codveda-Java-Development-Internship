package Level3;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Simple Book model class
    static class Book {
        int id;
        String title;
        String author;
        boolean isIssued;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        public void display() {
            System.out.printf("ID: %d | Title: '%s' | Author: '%s' | Status: %s%n",
                    id, title, author, (isIssued ? "Issued" : "Available"));
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Library Management System!");

        while (!exit) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choiceInput = scanner.nextLine().trim();
            int choice = -1;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                // choice remains -1
            }

            switch (choice) {
                case 1:
                    // Add Book
                    System.out.print("Enter Book ID: ");
                    String idStr = scanner.nextLine().trim();
                    int id;
                    try {
                        id = Integer.parseInt(idStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Book ID must be an integer.");
                        break;
                    }

                    // Check if ID already exists
                    boolean exists = false;
                    for (Book b : books) {
                        if (b.id == id) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Error: A book with this ID already exists.");
                        break;
                    }

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("Error: Title cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine().trim();
                    if (author.isEmpty()) {
                        System.out.println("Error: Author cannot be empty.");
                        break;
                    }

                    books.add(new Book(id, title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    // View Books
                    if (books.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        System.out.println("\n--- Books in Library ---");
                        for (Book b : books) {
                            b.display();
                        }
                    }
                    break;

                case 3:
                    // Issue Book
                    System.out.print("Enter Book ID to issue: ");
                    String issueIdStr = scanner.nextLine().trim();
                    int issueId;
                    try {
                        issueId = Integer.parseInt(issueIdStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    boolean foundToIssue = false;
                    for (Book b : books) {
                        if (b.id == issueId) {
                            foundToIssue = true;
                            if (b.isIssued) {
                                System.out.println("Book is already issued.");
                            } else {
                                b.isIssued = true;
                                System.out.println("Book issued successfully!");
                            }
                            break;
                        }
                    }
                    if (!foundToIssue) {
                        System.out.println("Book with ID " + issueId + " not found.");
                    }
                    break;

                case 4:
                    // Return Book
                    System.out.print("Enter Book ID to return: ");
                    String returnIdStr = scanner.nextLine().trim();
                    int returnId;
                    try {
                        returnId = Integer.parseInt(returnIdStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    boolean foundToReturn = false;
                    for (Book b : books) {
                        if (b.id == returnId) {
                            foundToReturn = true;
                            if (!b.isIssued) {
                                System.out.println("Book was not issued.");
                            } else {
                                b.isIssued = false;
                                System.out.println("Book returned successfully!");
                            }
                            break;
                        }
                    }
                    if (!foundToReturn) {
                        System.out.println("Book with ID " + returnId + " not found.");
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 5.");
            }
        }
        scanner.close();
    }
}
