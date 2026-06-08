package Level2;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    
    // Inner class representing an Employee
    static class Employee {
        int id;
        String name;
        String designation;
        double salary;

        public Employee(int id, String name, String designation, double salary) {
            this.id = id;
            this.name = name;
            this.designation = designation;
            this.salary = salary;
        }

        // Method to display employee details
        public void display() {
            System.out.printf("ID: %d | Name: %s | Designation: %s | Salary: $%.2f%n", id, name, designation, salary);
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Employee Management System!");

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choiceInput = scanner.nextLine().trim();
            int choice = -1;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                // If input is not an integer, choice remains -1 and falls to default switch block
            }

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter Employee ID: ");
                    String idStr = scanner.nextLine().trim();
                    int id;
                    try {
                        id = Integer.parseInt(idStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Employee ID must be a whole number.");
                        break;
                    }

                    // Check if employee ID already exists
                    boolean exists = false;
                    for (Employee emp : employees) {
                        if (emp.id == id) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Error: An employee with this ID already exists.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Error: Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Designation: ");
                    String designation = scanner.nextLine().trim();
                    if (designation.isEmpty()) {
                        System.out.println("Error: Designation cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Salary: ");
                    String salaryStr = scanner.nextLine().trim();
                    double salary;
                    try {
                        salary = Double.parseDouble(salaryStr);
                        if (salary < 0) {
                            System.out.println("Error: Salary cannot be negative.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Salary. Please enter a valid decimal number.");
                        break;
                    }

                    employees.add(new Employee(id, name, designation, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    // View All Employees
                    if (employees.isEmpty()) {
                        System.out.println("No employees in the system.");
                    } else {
                        System.out.println("\n--- Employee List ---");
                        for (Employee emp : employees) {
                            emp.display();
                        }
                    }
                    break;

                case 3:
                    // Search Employee by ID
                    System.out.print("Enter Employee ID to search: ");
                    String searchIdStr = scanner.nextLine().trim();
                    int searchId;
                    try {
                        searchId = Integer.parseInt(searchIdStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    boolean found = false;
                    for (Employee emp : employees) {
                        if (emp.id == searchId) {
                            System.out.println("\n--- Employee Details ---");
                            emp.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee with ID " + searchId + " not found.");
                    }
                    break;

                case 4:
                    // Delete Employee
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteIdStr = scanner.nextLine().trim();
                    int deleteId;
                    try {
                        deleteId = Integer.parseInt(deleteIdStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    boolean removed = false;
                    for (int i = 0; i < employees.size(); i++) {
                        if (employees.get(i).id == deleteId) {
                            employees.remove(i);
                            System.out.println("Employee deleted successfully!");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Employee with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Employee Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a option between 1 and 5.");
            }
        }
        scanner.close();
    }
}
