package com.librarymanagementsystem.students;

import com.librarymanagementsystem.book.Book;
import com.librarymanagementsystem.transactions.UserTransactions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian Adewunmi
 * @date 06/01/2020
 * This class is used to create a student object
 */
public class Student extends UserTransactions {

    private final String name;
    private final int studentId;
    private final String email;
    private final String studentUsername;
    private final String studentPassword;
    private List<Book> listOfBooks;


    /**
     * This is the constructor for the student class
     * @param name: student name
     * @param studentId: student id
     * @param email: student email
     */

    public Student(String name, int studentId, String email,
                   String studentUsername, String studentPassword) {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + "\n"
                + "Student ID: " + studentId + "\n"
                + "Email: " + email + "\n";
    }

    /**
     * This method is used to give the student access to the
     * list of books, created by a librarian.
     * @param list: book object
     */
    public void getAllBooksFromUserTransactions(ArrayList<Book> list){
        this.listOfBooks = (List<Book>) list.clone();
    }

    /**
     * This method is used to search for a book by ISBN.
     * @param isbn: book ISBN
     * @return book object
     */
    public boolean findBookByISBNFromStudentAccount(int isbn) {
        for (Book book : listOfBooks) {
            if (book.getISBN() == isbn) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to print result from a search for a book by ISBN.
     * @param isbn: book ISBN
     */
    public void printABookFromStudentAccount(int isbn) {
        for (Book book : listOfBooks) {
            if (book.getISBN() == isbn) {
                System.out.println(book);
            }
        }
    }

    /**
     * This method is used to search for a book by title.
     * @param title: book title
     * @return book object
     */

    public boolean findBookByTitleFromStudentAccount(String title) {
        for (Book book : listOfBooks) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to print result from a search for a book by title.
     * @param title: book title
     */
    public void printABookByTitleFromStudentAccount(String title) {
        for (Book book : listOfBooks) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
            }
        }
    }

    /**
     * This method is used to search for a book by author.
     * @param author: book author
     * @return book object
     */
    public boolean findBookByAuthorFromStudentAccount(String author) {
        for (Book book : listOfBooks) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to print result from a search for a book by author.
     * @param author: book author
     */
    public void printABookByAuthorFromStudentAccount(String author) {
        for (Book book : listOfBooks) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    /*
     * This method is used to add a book to the list of books,
     * created by a librarian. It is a helper method for the
     * returnBook() method.
     */
    public void addBookFromStudentAccount(int ISBN, String name, String title){
        Book book = new Book(ISBN, name, title);
        listOfBooks.add(book);
    }

    /**
     * This method is used to remove a book from the list of books,
     * created by a librarian. It is a helper method for the
     * borrowBook() method.
     */
    public void removeBookFromStudentAccount(String title){
        listOfBooks.removeIf(book1 -> book1.getBookTitle().equalsIgnoreCase(title));
    }

    /**
     * This method is used to borrow a book from the list of books,
     * by a student.
     * @param title
     */
    public void borrowBook(String title){
        for (Book book : listOfBooks) {
            if (book.getBookTitle().equals(title)) {
                if (!(book.isBorrowed())) {
                    book.borrowed();
                    System.out.println("You have successfully borrowed " + title);
                    removeBookFromStudentAccount(title);
                    System.out.println("\n***List Of Books After Book Borrowed!***\n");
                    printListOfBooksFromStudentAccount();
                    return;
                }
            }
            if(!(book.getBookTitle().equals(title))){
                System.out.println("Sorry, this book is already borrowed!");
                return;
            }
        }
        System.out.println("Book not found in catalog!");
    }

    /**
     * This method is used to return a book from the list of books,
     * by a student.
     * @param title
     */
    public void returnBook(int ISBN, String name, String title){
        for (Book book : listOfBooks) {
            removeBookFromStudentAccount(title);
            if (!(book.getBookTitle().equals(title))){
                if (!(book.isBorrowed())) {
                    book.returned();
                    addBookFromStudentAccount(ISBN, name, title);
                    System.out.println("Book returned: " + title);
                    System.out.println("\n***List Of Books After Book Returned!***\n");
                    printListOfBooksFromStudentAccount();
                    return;
                }
            }
        }
    }

    /**
     * This method is used to print the list of books.
     */
    public void printListOfBooksFromStudentAccount(){
        for (Book book : listOfBooks) {
            System.out.println(book);
        }
    }
}
