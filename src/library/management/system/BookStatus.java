/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

/**
 *
 * @author zibon
 */
public class BookStatus {
    public Book Book;
    public int TotalStock,Rented;  
        
    public Book getBook() {return Book;}
    public void setBook(Book Book) {this.Book = Book;}
    
    public int  getTotalStock() {return TotalStock;    }
    public void setTotalStock(int TotalStock) {this.TotalStock = TotalStock;}
    
    public int  getRented() {return Rented;}
    public void setRented(int Rented) {this.Rented = Rented;}

    public BookStatus (){    }
    public BookStatus (Book book) {
    this.Book=book;
    }
    
    public BookStatus (Book book,int totalStock,int rented) {
    this.Book=book;
    this.TotalStock=totalStock;
    this.Rented=rented;
    }    
}
