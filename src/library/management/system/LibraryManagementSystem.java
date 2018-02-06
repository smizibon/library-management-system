/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author zibon
 */
public class LibraryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static BookStatus createBookObjectFromUser() {
        int ID;
        String Title, Author;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Id for the book : ");
        ID = scanner.nextInt();
        scanner.nextLine();//memory clear
        System.out.println("Enter Tiltle : ");
        Title = scanner.nextLine();
        System.out.println("Enter Author book : ");
        Author = scanner.nextLine();

        Book book = new Book(ID, Title, Author);
        //add entry to book status 

        BookStatus bookEntry = new BookStatus(book);

        System.out.println("How many Copies ? ");
        bookEntry.setTotalStock(scanner.nextInt());
        bookEntry.setRented(0);

        return bookEntry;
    }

    public void removeBookFromInventory() {
    }

//    public Book searchBookFromInventorybyID(int id){ 
//        return Book;
//    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        //add items to 
        // Let us create a list
        List<Book> BookInformation = new ArrayList<Book>();
        List<BookStatus> BookInventory = new ArrayList<BookStatus>();
        //create book       
        BookStatus bookstatus = createBookObjectFromUser();
        System.out.println(bookstatus.getBook().getID());
        System.out.println(bookstatus.getBook().getTitle());
        System.out.println(bookstatus.getBook().getAuthor());
        System.out.println(bookstatus.getTotalStock());
        
        
        ReadWrite readWrite=new ReadWrite();
        readWrite.WriteLineToTextFile(bookstatus.getBook().toCsv(), "bookstatus");

        //Book book =new Book() ;
        //dummy data
        Book book1 = new Book(1, "India vromoner dinlipi", "Shah Mustofa Khaled");
        Book book2 = new Book(2, "pakistan vromoner dinlipi", "Shah Mustofa Khaled");
        Book book3 = new Book(3, "malaysia vromoner dinlipi", "Shah Mustofa Khaled");
        Book book4 = new Book(4, "Bangladesh vromoner dinlipi", "Shah Mustofa Khaled");
        Book book5 = new Book(5, "portugal vromoner dinlipi", "Shah Mustofa Khaled");
        Book book6 = new Book(6, "USA vromoner dinlipi", "Shah Mustofa Khaled");
        Book book7 = new Book(7, "England vromoner dinlipi", "Shah Mustofa Khaled");
        //populate list of books

        BookInformation.add(book1);
        BookInformation.add(book2);
        BookInformation.add(book3);
        BookInformation.add(book4);
        BookInformation.add(book5);
        BookInformation.add(book6);
        BookInformation.add(book7);

 

        //add the new book to book list
        //BookInformation.add(bookstatus.Book.);
        //print all Booknames
        for (int i = 0; i < BookInformation.size(); i++) {
            System.out.print(BookInformation.get(i).getID() + "   ");
            System.out.print(BookInformation.get(i).getTitle() + "  ");
            System.out.println(BookInformation.get(i).getAuthor() + "  ");
        }
        //generate status for each book
        BookStatus bk2 = new BookStatus(book2, 0, 10);
        BookStatus bk3 = new BookStatus(book3, 0, 10);
        BookStatus bk4 = new BookStatus(book4, 0, 10);
        BookStatus bk5 = new BookStatus(book5, 0, 10);
        BookStatus bk6 = new BookStatus(book6, 0, 10);
        BookStatus bk7 = new BookStatus(book7, 0, 10);
        //
        BookInventory.add(bk2);
        BookInventory.add(bk3);
        BookInventory.add(bk4);
        BookInventory.add(bk5);
        BookInventory.add(bk6);
        BookInventory.add(bk7);
        BookInventory.add(bookstatus);

        //print all Book Inventory 
        for (int i = 0; i < BookInventory.size(); i++) {
            System.out.print(BookInventory.get(i).Book.ID + "   ");
            System.out.print(BookInventory.get(i).Book.Title + "  ");
            System.out.print(BookInventory.get(i).Book.Author + "  ");
            System.out.print(BookInventory.get(i).Rented + "  ");
            System.out.println(BookInventory.get(i).TotalStock + "  ");
        }
        //
        readWrite.PrintWholeTextFile ("bookstatus");
        
        
        
    //rent 
    //return book
    //search 
}
}

