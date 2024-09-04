package com.librarymanagementsystem.administrator;

import com.librarymanagementsystem.book.Book;
import com.librarymanagementsystem.librarian.Librarian;
import com.librarymanagementsystem.students.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian Adewunmi
 * @date 28/02/2020
 * This class is used to create a new administrator,
 * for registering new students and librarians.
 */

public class Administrator {
    String adminUserName;
    String adminPassword;
    private final List<Librarian> listOfLibrarians;
    private final List<Student> listOfStudents;

    /**
     * This is the constructor for the Administrator class.
     * adminUserName: The username of the administrator
     * adminPassword: The password of the administrator
     */
    public Administrator() {
        this.listOfLibrarians = new ArrayList<Librarian>();
        this.listOfStudents = new ArrayList<Student>();
        this.adminUserName = "admin";
        this.adminPassword = "admin";
    }

    /**
     * This method is used to log in by admin.
     * admin: The admin to be logged in
     */
    public boolean adminLogin(String username, String password){
        if(username.equals("admin") && password.equals("admin")){
            System.out.println("Administrator Login Successful!");
            return true;
        }else {
            System.out.println("Administrator Login Failed!");
        }
        return false;
    }

    /**
     * This method is used to register a new librarian.
     * librarian: The librarian to be registered
     */
    public void createLibrarian(String librarianName, int librarianIDNumber, String librarianEmail, String librarianUserName, String librarianPassword){
        Librarian librarian = new Librarian(librarianName, librarianIDNumber, librarianEmail, librarianUserName, librarianPassword);
        listOfLibrarians.add(librarian);
    }

    /**
     * This method is used to remove a librarian.
     * librarian: The librarian to be removed
     */
    public boolean removeLibrarian(int librarianIDNumber){
        for (Librarian librarian : listOfLibrarians) {
            if (librarian.getLibrarianIDNumber() == librarianIDNumber){
                listOfLibrarians.remove(librarian);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to print all librarians.
     * librarian: The librarian to be printed
     */
    public void printLibrarians(){
        for (Librarian librarian : listOfLibrarians) {
            System.out.println(librarian);
        }
    }

    /**
     * This method is used to search for a librarian by ID Number.
     * librarian: The librarian to be searched
     */
    public boolean searchLibrarian(int librarianIDNumber){
        for (Librarian librarian : listOfLibrarians) {
            if (librarian.getLibrarianIDNumber() == librarianIDNumber){
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to log in by librarian.
     * librarian: The librarian to be logged in
     */
    public boolean librarianLogin(String username, String password){
        for (Librarian librarian : listOfLibrarians) {
            if(username.equals(librarian.getLibrarianUserName()) && password.equals(librarian.getLibrarianPassword())){
                System.out.println("Librarian Login Successful!");
                return true;
            }else {
                System.out.println("Librarian Login Failed!");
            }
        }
        return false;
    }

    /**
     * This method is used to add new book to library.
     * book: The book to be added
     */
    public void addBook(int ISBN, String name, String title){
        for (Librarian librarian : listOfLibrarians) {
            if (!librarian.searchByISBN(ISBN)) {
                librarian.addBook(ISBN, name, title);
                System.out.println("Book added successfully\nBy: " + librarian.getLibrarianName());
            } else {
                System.out.println("Book already exists\n");
            }
        }
    }

    /**
     * This method is used to remove a book from library.
     * book: The book to be removed
     */
    public void removeBook(int ISBN){
        for (Librarian librarian : listOfLibrarians) {
            if (librarian.searchByISBN(ISBN)) {
                librarian.removeBook(ISBN);
                System.out.println("Book removed successfully\nBy: " + librarian.getLibrarianName());
            }else {
                System.out.println("Book does not exist\n");
            }
        }
    }

    /**
     * This method is used by Librarian to search for a book by ISBN.
     * book: The book to be searched
     */
    public boolean searchBookISBN(int ISBN){
        for (Librarian librarian : listOfLibrarians) {
            if (librarian.searchByISBN(ISBN)) {
                System.out.println("Book found!");
                librarian.printABook(ISBN);
                return true;
            }
        }
        System.out.println("Book does not exist!\n");
        return false;
    }

    /**
     * This method is used to search for a book by title.
     * book: The book to be searched
     */
    public boolean searchBookTitle(String title){
        for (Librarian librarian : listOfLibrarians) {
            if (librarian.searchByTitle(title)) {
                System.out.println("Book found!");
                librarian.printABookTitle(title);
                return true;
            }
        }
        System.out.println("Book does not exist!\n");
        return false;
    }

    /**
     * This method is used to search for a book by author name.
     * book: The book to be searched
     */
    public boolean searchBookAuthor(String name){
        for (Librarian librarian : listOfLibrarians) {
            if (librarian.searchByAuthor(name)) {
                System.out.println("Book found!");
                librarian.printABookAuthor(name);
                return true;
            }
        }
        System.out.println("Book does not exist!\n");
        return false;
    }

    /**
     * This method is used to print books from library.
     * book: The book to be printed
     */
    public void printBooks(){
        for (Librarian librarian : listOfLibrarians) {
            librarian.printAllBooks();
        }
    }

    /**
     * This method is used to create new student.
     * student: The student to be created
     */
    public void createStudent(String name, int studentId, String email, String userName, String password){
        Student student = new Student(name, studentId, email, userName, password);
        listOfStudents.add(student);
    }

    /**
     * This method is used to print all students.
     * student: The student to be printed
     */
    public void printStudents(){
        for (Student student : listOfStudents) {
            System.out.println(student);
        }
    }

    /**
     * This method is used to search for a student by ID Number.
     * student: The student to be searched
     */
    public boolean searchStudent(int studentIDNumber){
        for (Student student : listOfStudents) {
            if (student.getStudentId() == studentIDNumber){
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to remove a student.
     * student: The student to be removed
     */
    public boolean removeStudent(int studentIDNumber){
        for (Student student : listOfStudents) {
            if (student.getStudentId() == studentIDNumber){
                listOfStudents.remove(student);
                return true;
            }
        }
        return false;
    }


    /**
     * This method is used to log in by student.
     * student: The student to be logged in
     */
    public boolean studentLogin(String username, String password){
        for (Student student : listOfStudents) {
            if(username.equals(student.getStudentUsername()) && password.equals(student.getStudentPassword())){
                System.out.println("Student Login Successful!");
                return true;
            }else {
                System.out.println("Student Login Failed!");
            }
        }
        return false;
    }

    /**
     * This method is used by a student to search for a book by ISBN.
     * book: The book to be searched
     */
    public void findBookByISBNFromStudentAccount(int isbn){
        for (Librarian librarian: listOfLibrarians) {
            for (Student student : listOfStudents) {
                student.getAllBooksFromUserTransactions((ArrayList<Book>)
                        librarian.getListOfBooks());
                if (student.findBookByISBNFromStudentAccount(isbn)) {
                    student.printABookFromStudentAccount(isbn);
                }else{
                    System.out.println("Book does not exit");
                }
            }
        }
    }

    /**
     * This method is used by a student to search for a book by title.
     * book: The book to be searched
     */
    public void findBookByTitleFromStudentAccount(String title){
        for (Librarian librarian: listOfLibrarians) {
            for (Student student : listOfStudents) {
                student.getAllBooksFromUserTransactions((ArrayList<Book>)
                        librarian.getListOfBooks());
                if (student.findBookByTitleFromStudentAccount(title)) {
                    student.printABookByTitleFromStudentAccount(title);
                }else{
                    System.out.println("Book does not exit");
                }
            }
        }
    }

    /**
     * This method is used by a student to search for a book by author.
     * book: The book to be searched
     */
    public void findBookByAuthorFromStudentAccount(String author){
        for (Librarian librarian: listOfLibrarians) {
            for (Student student : listOfStudents) {
                student.getAllBooksFromUserTransactions((ArrayList<Book>)
                        librarian.getListOfBooks());
                if (student.findBookByAuthorFromStudentAccount(author)) {
                    student.printABookByAuthorFromStudentAccount(author);
                }else{
                    System.out.println("Book does not exit");
                }
            }
        }
    }

    /**
     * This method is used by a student to borrow a book.
     */
    public void studentBorrowBook(String title){
        for (Student student : listOfStudents) {
            student.borrowBook(title);
        }
    }

    /**
     * This method is used by a student to return a book.
     */
    public void studentReturnBook(int ISBN, String name, String title){
        for (Student student : listOfStudents) {
            student.returnBook(ISBN, name, title);
        }
    }
}
