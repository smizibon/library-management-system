/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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
    // Let us create a list

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
    public void printAllbooks() {
    }

    public void main() {

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        List<Book> BookInformation = new ArrayList<Book>();
        List<BookStatus> BookInventory = new ArrayList<BookStatus>();

        //add items to 
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

//        try {           String FileName = "out";
//			File file = new File(String.format("%s.txt", FileName));
//			FileReader fileReader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			StringBuffer stringBuffer = new StringBuffer();
//			String line;
//			while ((line = bufferedReader.readLine()) != null) {
//                            BookInformation.add(new Book(1, "",""));
//                            
//                            stringBuffer.append(line);
//                            stringBuffer.append("\n");
//			}
//			fileReader.close();
//			System.out.println("Contents of file:");
//			System.out.println(stringBuffer.toString());
//                        
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

        BookInformation.add(book1);
        BookInformation.add(book2);
        BookInformation.add(book3);
        BookInformation.add(book4);
        BookInformation.add(book5);
        BookInformation.add(book6);
        BookInformation.add(book7);


        //generate status for each book
        BookStatus bk1 = new BookStatus(book1, 0, 10);
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

        //print all Book Inventory 
        ReadWrite readWrite = new ReadWrite();
        //readWrite.PrintWholeTextFile("bookstatus");

        System.out.println("What do you want to do  ? ");
        System.out.println("press 1 to Create a book ");
        System.out.println("Press 2 to search for a book ");
        System.out.println("press 3 to rent a book");
        System.out.println("press 4 to manage books");
        System.out.println("press 5 to print all books");

        Scanner scanner = new Scanner(System.in);
        String KeyboardInput = "";
        while (KeyboardInput != "exit") {
            KeyboardInput = scanner.nextLine();
            switch (KeyboardInput) {
                case "exit" :
                    KeyboardInput="exit";
                    break;
                case "1":  //create book       
                    BookStatus bookstatus = createBookObjectFromUser();
               
                    
                    BookInformation.add(bookstatus.getBook());//add to the book list 
                    BookInventory.add(bookstatus);//add to inventory
                    //readWrite.WriteLineToTextFile(bookstatus.getBook().toCsv(), "bookstatus");//add to book file
                    System.out.println("book added to book list and inventory");
                    
                    System.out.println(bookstatus.getBook().getID());
                    System.out.println(bookstatus.getBook().getTitle());
                    System.out.println(bookstatus.getBook().getAuthor());
                    System.out.println(bookstatus.getTotalStock());
                    
                    break;
                case "2":  //search
                    System.out.println("Enter the ID you want to search for ");
                    KeyboardInput = scanner.nextLine();
                    //read from file
                    //System.out.println(readWrite.SearchForBookByID("2", "bookstatus"));

                    //read from list
                    for (int i = 0; i < BookInformation.size(); i++) {
                        if (BookInformation.get(i).getID() == Integer.parseInt(KeyboardInput)) {
                            System.out.print("form list : \n" + BookInformation.get(i).getID() + "   ");
                            System.out.print(BookInformation.get(i).getTitle() + "  ");
                            System.out.println(BookInformation.get(i).getAuthor() + "  ");
                        }
                    }
                    break;

                case "3": //rent 
                    System.out.println("Which book do you want to rent (type the ID ): ");
                    KeyboardInput = scanner.nextLine();

                    //search index number 
                    boolean found = false;
                    int foundItemIndexNumber = 0;
                    for (int i = 0; i < BookInventory.size(); i++) {
                        if (BookInformation.get(i).getID() == Integer.parseInt(KeyboardInput)) {
                            System.out.print("form list : \n" + BookInventory.get(i).getBook().getID() + "   ");
                            System.out.print(BookInventory.get(i).getBook().getTitle() + "  ");
                            System.out.println(BookInventory.get(i).getBook().getAuthor() + "  ");
                            foundItemIndexNumber = i;
                        }
                    }
                    //choose for user 
                    System.out.println("Choose 1 to rent and 2 to decline  ");
                    String choice = scanner.nextLine();
                    if (choice == "1") {
                        while (BookInventory.get(foundItemIndexNumber).getRented() != 0) {
                            int a = BookInventory.get(foundItemIndexNumber).getRented() - 1;
                            BookInventory.get(foundItemIndexNumber).setRented(a);
                        }
                    } else {
                        System.out.println("");
                    }

                    break;
                case "4":  //manage book
                    System.out.println("");
                    break;
                case "5":   //print all book details  
                    System.out.println("______________________________________________");
                    System.out.println("");
                    System.out.println("ID -- Title -- Author -- TotalStock -- Rented");
                    System.out.println("______________________________________________");
                    System.out.println("");
                    //does not print index 1
                    for (int i = 0; i < BookInventory.size(); i++) {
                        System.out.print(BookInventory.get(i).getBook().getID() + " -- ");
                        System.out.print(BookInventory.get(i).getBook().getTitle() + " -- ");
                        System.out.print(BookInventory.get(i).getBook().getAuthor() + " -- ");
                        System.out.print(BookInventory.get(i).getRented() + " -- ");
                        System.out.println(BookInventory.get(i).getRented() + "");
                    }
                    break;

                default:
                    String message = "please choose any number between 1- 5 ";
                    System.out.println(message);
                    break;
            }
            //rent 
            //return book
            //search         //rent 
            //return book
            //search 
        }
    }

}
