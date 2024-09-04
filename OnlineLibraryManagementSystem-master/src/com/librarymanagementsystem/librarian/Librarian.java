package com.librarymanagementsystem.librarian;

import com.librarymanagementsystem.transactions.UserTransactions;

/**
 * @author Adrian Adewunmi
 * @date 24/01/2022
 * This class is used to create a librarian object
 */
public class Librarian extends UserTransactions {
    private final String librarianName;
    private final int librarianIDNumber;
    private final String librarianEmail;
    private final String librarianUserName;
    private final String librarianPassword;

    /**
     * This is a constructor for the librarian class
     * @param librarianName: The name of the librarian
     * @param librarianIDNumber: The id number of the librarian
     * @param librarianEmail: The email of the librarian
     */
    public Librarian(String librarianName, int librarianIDNumber, String librarianEmail, String librarianUserName, String librarianPassword) {
        this.librarianName = librarianName;
        this.librarianIDNumber = librarianIDNumber;
        this.librarianEmail = librarianEmail;
        this.librarianUserName = librarianUserName;
        this.librarianPassword = librarianPassword;
    }
    /**
     * This method is used to get the librarian name
     * @return librarianName
     */
    public String getLibrarianName() {
        return librarianName;
    }
    /**
     * This method is used to get the librarian id number
     * @return librarianIDNumber
     */
    public int getLibrarianIDNumber() {
        return librarianIDNumber;
    }
    /**
     * This method is used to get the librarian email
     * @return librarianEmail
     */
    public String getLibrarianEmail() {
        return librarianEmail;
    }
    /**
     * This method is used to get the librarian username
     * @return librarianUserName
     */
    public String getLibrarianUserName() {
        return librarianUserName;
    }
    /**
     * This method is used to get the librarian password
     * @return librarianPassword
     */
    public String getLibrarianPassword() {
        return librarianPassword;
    }

    @Override
    public String toString() {
        return "Librarian Name: " + librarianName + "\n" +
                "Librarian ID Number: " + librarianIDNumber + "\n" +
                "Librarian Email: " + librarianEmail + "\n";
    }

}
