package com.librarymanagementsystem.library;

import com.librarymanagementsystem.administrator.Administrator;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Adrian Adewunmi
 * @date 19/01/2022
 * This is the main class of the library management system.
 * It gives the UI for the user to interact with the system.
 */
public class LibraryMain {
    public static void main(String[] args) {
        int menuChoice;
        int loginChoice;
        int adminChoice;
        int librarianMenuChoice;
        int searchChoice;
        int studentMenuChoice;
        int studentSearchChoice;


        Library library = new Library("London University Library",
                "Finsbury Park, London, UK");
        System.out.println(library);
        System.out.println("*** Welcome to the Library Management System (LMS) ***");
        LocalDate date = LocalDate.now();
        System.out.println("*** Date: " + date + " ***");
        Scanner scanner = new Scanner(System.in);
        Administrator admin = new Administrator();

        do {
            System.out.println("\nPlease select an option:\n" +
                    "\n1. Admin Login" +
                    "\n2. Librarian Login" +
                    "\n3. Student Login" +
                    "\n4. Exit");
            menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1:
                    // Administrator Login Menu
                    do {
                        System.out.println("\n*** Administrator Login ***\n");
                        System.out.println("Please select an option: "
                                + "\n1. Login"
                                + "\n2. Exit");
                        loginChoice = scanner.nextInt();
                        switch (loginChoice) {
                            case 1:
                                System.out.println("Loging ... ");
                                System.out.println("\nPlease enter your login details: ");
                                System.out.print("Username: ");
                                String username = scanner.next();
                                System.out.print("Password: ");
                                String password = scanner.next();
                                if (admin.adminLogin(username, password)) {
                                    // Administrator Menu after login
                                    do {
                                        System.out.println("\nPlease select an option from the menu below:\n"
                                                + "1. Register a new librarian\n"
                                                + "2. Delete a librarian\n"
                                                + "3. Print all librarians\n"
                                                + "4. Register a new student\n"
                                                + "5. Delete a student\n"
                                                + "6. Print all students\n"
                                                + "7. Exit\n");
                                        adminChoice = scanner.nextInt();
                                        switch (adminChoice) {
                                            case 1:
                                                Scanner scanner1 = new Scanner(System.in);
                                                char y;
                                                // Register a new librarian
                                                do {
                                                    System.out.println("Register a new librarian ... ");
                                                    System.out.println("\nPlease enter the details of the new librarian: ");
                                                    System.out.print("Enter the librarian's name: \n");
                                                    String librarianName = scanner1.nextLine();
                                                    scanner1.nextLine();
                                                    System.out.println("Enter the librarian's Email Address: ");
                                                    String librarianEmail = scanner1.nextLine();
                                                    System.out.print("Enter the librarian's user ID Number: \n");
                                                    int librarianIDNumber = scanner1.nextInt();
                                                    System.out.println("Enter the librarian's User Name: ");
                                                    String librarianUserName = scanner1.next();
                                                    System.out.println("Enter the librarian's Password: ");
                                                    String librarianPassword = scanner1.next();
                                                    if (admin.searchLibrarian(librarianIDNumber)) {
                                                        System.out.println("Librarian already exists");
                                                        System.out.println("Do you want to add another librarian? (y/n)");
                                                    } else {
                                                        admin.createLibrarian(librarianName, librarianIDNumber, librarianEmail, librarianUserName, librarianPassword);
                                                        System.out.println("Librarian successfully registered!");
                                                        System.out.println("\nDo you want to register another librarian? (y/n)");
                                                    }
                                                    y = scanner1.next().charAt(0);
                                                } while (y == 'y');
                                                break;
                                            case 2:
                                                char z;
                                                // Delete a librarian
                                                do {
                                                    System.out.println("Delete a librarian ... ");
                                                    System.out.println("\nPlease enter the details of the librarian to be deleted: ");
                                                    System.out.print("Enter the librarian's user ID Number: ");
                                                    int librarianIDNumber = scanner.nextInt();
                                                    if (admin.searchLibrarian(librarianIDNumber)) {
                                                        admin.removeLibrarian(librarianIDNumber);
                                                        System.out.println("Librarian successfully deleted!");
                                                        System.out.println("Do you want to add another librarian? (y/n)");
                                                    } else {
                                                        System.out.println("Librarian does not exist");
                                                        System.out.println("\nDo you want to delete another librarian? (y/n)");
                                                    }
                                                    z = scanner.next().charAt(0);
                                                } while (z == 'y');
                                                break;
                                            case 3:
                                                // Print all librarians
                                                System.out.println("Print a list of all librarians ...");
                                                admin.printLibrarians();
                                                break;
                                            case 4:
                                                Scanner scanner2 = new Scanner(System.in);
                                                char a;
                                                // Register a student
                                                do {
                                                    System.out.println("Register a new student ... ");
                                                    System.out.println("\nPlease enter the details of the new student: ");
                                                    System.out.print("Enter the student's name: \n");
                                                    String studentName = scanner2.nextLine();
                                                    scanner2.nextLine();
                                                    System.out.println("Enter the student's Email Address: ");
                                                    String studentEmail = scanner2.nextLine();
                                                    System.out.print("Enter the student's user ID Number: \n");
                                                    int studentIDNumber = scanner2.nextInt();
                                                    System.out.println("Enter the student's username: ");
                                                    String studentUserName = scanner2.next();
                                                    System.out.println("Enter the student's password: ");
                                                    String studentPassword = scanner2.next();
                                                    if (admin.searchStudent(studentIDNumber)) {
                                                        System.out.println("Student already exists");
                                                        System.out.println("Do you want to add another student? (y/n)");
                                                    } else {
                                                        admin.createStudent(studentName, studentIDNumber, studentEmail, studentUserName, studentPassword);
                                                        System.out.println("Student successfully registered!");
                                                        System.out.println("\nDo you want to register another Student? (y/n)");
                                                    }
                                                    a = scanner2.next().charAt(0);
                                                } while (a == 'y');
                                                break;
                                            case 5:
                                                char b;
                                                // Delete a student
                                                do {
                                                    System.out.println("Delete a student ... ");
                                                    System.out.println("\nPlease enter the details of the student to be deleted: ");
                                                    System.out.print("Enter the student's user ID Number: ");
                                                    int studentIDNumber = scanner.nextInt();
                                                    if (admin.searchStudent(studentIDNumber)) {
                                                        admin.removeStudent(studentIDNumber);
                                                        System.out.println("Student successfully deleted!");
                                                        System.out.println("Do you want to add another student? (y/n)");
                                                    } else {
                                                        System.out.println("Student does not exist");
                                                        System.out.println("\nDo you want to delete another student? (y/n)");
                                                    }
                                                    b = scanner.next().charAt(0);

                                                } while (b == 'y');
                                                break;
                                            case 6:
                                                // View all students
                                                System.out.println("Print a list of all students ... ");
                                                admin.printStudents();
                                                break;
                                            case 7:
                                                System.out.println("Exiting Administrator Menu ... " +
                                                        "\n ... Returning to Administrator Login Menu");
                                                break;
                                            default:
                                                System.out.println("Invalid choice");
                                                break;
                                        }

                                    } while (adminChoice != 7);
                                }
                                break;
                            case 2:
                                System.out.println("Loging Out ... \nExiting Administrator Login Menu");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }

                    } while (loginChoice != 2);
                    break;
                case 2:
                    // Library Staff Login
                    do {
                        System.out.println("\n*** Librarian Login ***\n");
                        System.out.println("Please select an option: ");
                        System.out.println("1. Login");
                        System.out.println("2. Exit");
                        librarianMenuChoice = scanner.nextInt();
                        switch (librarianMenuChoice){
                            case 1:
                                System.out.println("Loging ... ");
                                System.out.println("\nPlease enter your login details: ");
                                System.out.print("Username: ");
                                String username = scanner.next();
                                System.out.print("Password: ");
                                String password = scanner.next();
                                if (admin.librarianLogin(username, password)) {
                                    do {
                                        // Librarian Menu after login
                                        System.out.println("\nLibrarian Menu\n"
                                                + "Please select an option from the menu below:\n"
                                                + "1. Search Book\n"
                                                + "2. Add Book\n"
                                                + "3. Remove Book\n"
                                                + "4. Print Books\n"
                                                + "5. Exit to Librarian Login Menu\n");
                                        librarianMenuChoice = scanner.nextInt();
                                        switch (librarianMenuChoice) {
                                            // Search Book
                                            case 1:
                                                Scanner scannerSearch = new Scanner(System.in);
                                                do {
                                                    System.out.println("\nLibrarian Book Search Menu\n"
                                                            + "Please select an option from the menu below:\n"
                                                            + "1. Search by ISBN\n"
                                                            + "2. Search by Author\n"
                                                            + "3. Search by Title\n"
                                                            + "4. Exit\n");
                                                    searchChoice = scanner.nextInt();
                                                    switch (searchChoice) {
                                                        case 1:
                                                            System.out.println("Searching by ISBN ... ");
                                                            System.out.print("Enter ISBN: ");
                                                            int isbn = scannerSearch.nextInt();
                                                            admin.searchBookISBN(isbn);
                                                            break;
                                                        case 2:
                                                            System.out.println("Searching by Author ... ");
                                                            System.out.print("Enter Author Name: ");
                                                            scannerSearch.nextLine();
                                                            String author = scannerSearch.nextLine();
                                                            admin.searchBookAuthor(author);
                                                            break;
                                                        case 3:
                                                            System.out.println("Searching by Title ... ");
                                                            System.out.print("Enter Title: ");
                                                            String title = scannerSearch.nextLine();
                                                            admin.searchBookTitle(title);
                                                            break;
                                                        case 4:
                                                            System.out.println("Exiting to Librarian Menu");
                                                            break;
                                                        default:
                                                            System.out.println("Invalid input. Please try again.");
                                                            break;
                                                    }
                                                }while (searchChoice != 4);
                                                break;
                                            case 2:
                                                // Register Book
                                                Scanner scannerRegisterBook = new Scanner(System.in);
                                                char c;
                                                do {
                                                    System.out.println("Register Book ... ");
                                                    System.out.print("Enter Book ISBN: ");
                                                    int isbn = scannerRegisterBook.nextInt();
                                                    scannerRegisterBook.nextLine();
                                                    System.out.print("Enter Book Author Name: ");
                                                    String author = scannerRegisterBook.nextLine();
                                                    System.out.print("Enter Book Title: ");
                                                    String title = scannerRegisterBook.nextLine();
                                                    admin.addBook(isbn, author, title);
                                                    System.out.println("Do you want to add another book? (y/n)");
                                                    c = scannerRegisterBook.next().charAt(0);
                                                }while (c == 'y');
                                                break;
                                            case 3:
                                                // Remove Book
                                                Scanner scannerRemoveBook = new Scanner(System.in);
                                                char d;
                                                do {
                                                System.out.println("Remove Book ..");
                                                System.out.print("Enter Book ISBN: ");
                                                int isbn = scannerRemoveBook.nextInt();
                                                admin.removeBook(isbn);
                                                System.out.println("Do you want to remove another book? (y/n)");
                                                d = scannerRemoveBook.next().charAt(0);
                                                }while (d == 'y');
                                                break;
                                            case 4:
                                                // Print all books
                                                System.out.println("Print Books");
                                                admin.printBooks();
                                                break;
                                            case 5:
                                                System.out.println("Exit to Librarian Login Menu");
                                                break;
                                        }
                                    }while (librarianMenuChoice != 5);
                                    break;
                                }
                                break;
                            case 2:
                                System.out.println("Loging Out ... \nExiting Librarian Login Menu");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (librarianMenuChoice != 2);
                    break;
                case 3:
                    // Student menu
                    do {
                        System.out.println("\n***Student Login Menu***\n");
                        System.out.println("1. Login");
                        System.out.println("2. Exit");
                        studentMenuChoice = scanner.nextInt();
                        switch (studentMenuChoice) {
                            case 1:
                                // Student Login
                                System.out.println("Login ...");
                                System.out.println("\nPlease enter your login details: ");
                                System.out.print("Username: ");
                                String username = scanner.next();
                                System.out.print("Password: ");
                                String password = scanner.next();
                                if (admin.studentLogin(username, password)) {
                                    do {
                                        System.out.println("\nStudent Menu\n"
                                                + "Please select an option from the menu below:\n"
                                                + "1. Search Book\n"
                                                + "2. Borrow Book\n"
                                                + "3. Return Book\n"
                                                + "4. Exit to Student Login Menu\n");
                                        studentMenuChoice = scanner.nextInt();
                                        switch (studentMenuChoice) {
                                            case 1:
                                                Scanner studentScannerSearch = new Scanner(System.in);
                                                do{
                                                    System.out.println("\nStudent Book Search Menu\n"
                                                            + "Please select an option from the menu below:\n"
                                                            + "1. Search by ISBN\n"
                                                            + "2. Search by Author\n"
                                                            + "3. Search by Title\n"
                                                            + "4. Exit\n");
                                                    studentSearchChoice = scanner.nextInt();
                                                    switch (studentSearchChoice){
                                                        case 1:
                                                            System.out.println("Search By ISBN ... ");
                                                            System.out.println("Enter ISBN: ");
                                                            int isbn = studentScannerSearch.nextInt();
                                                            admin.findBookByISBNFromStudentAccount(isbn);
                                                            studentScannerSearch.nextLine();
                                                            break;
                                                        case 2:
                                                            System.out.println("Search By Author ... ");
                                                            System.out.println("Enter Author: ");
                                                            String author = studentScannerSearch.nextLine();
                                                            admin.findBookByAuthorFromStudentAccount(author);
                                                            studentScannerSearch.nextLine();
                                                            break;
                                                        case 3:
                                                            System.out.println("Search By Title ... ");
                                                            System.out.println("Enter Title: ");
                                                            String title = studentScannerSearch.nextLine();
                                                            admin.findBookByTitleFromStudentAccount(title);
                                                            break;
                                                        case 4:
                                                            System.out.println("Exiting to Student Menu");
                                                        default:
                                                            System.out.println("Invalid input. Please try again.");
                                                            break;
                                                    }
                                                }while(studentSearchChoice != 4);
                                                break;
                                            case 2:
                                                Scanner scannerStudentBorrow = new Scanner(System.in);
                                                System.out.println("Borrow Book ... ");
                                                System.out.println("Enter Book title: ");
                                                String title = scannerStudentBorrow.nextLine();
                                                admin.studentBorrowBook(title);
                                                scannerStudentBorrow.nextLine();
                                                break;
                                            case 3:
                                                Scanner scannerStudentReturn = new Scanner(System.in);
                                                System.out.println("Return Book ...");
                                                System.out.println("Enter ISBN:");
                                                int isbn = scannerStudentReturn.nextInt();
                                                scannerStudentReturn.nextLine();
                                                System.out.println("Enter Author:");
                                                String author = scannerStudentReturn.nextLine();
                                                scannerStudentReturn.nextLine();
                                                System.out.println("Enter Book title: ");
                                                String titleReturn = scannerStudentReturn.nextLine();
                                                admin.studentReturnBook(isbn, author, titleReturn);
                                                break;
                                            case 4:
                                                System.out.println("Exit to Main Menu");
                                                break;
                                        }
                                }while (studentMenuChoice != 4);
                                break;
                                }
                                break;
                            case 2:
                                System.out.println("Loging Out ... \nExiting Student Login Menu");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    }while (studentMenuChoice != 2);
                    break;
                case 4:
                    System.out.println("Exiting ... London University Library System");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (menuChoice != 4);
        scanner.close();
    }
}
