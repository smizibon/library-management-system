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
public class Book {
    
    public int ID;
    public String Title;
    public String Author;
    
     public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
     public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
     public String getAuthor() {
        return Author;
    }
    public void setAuthor(String Author) {
        this.Author = Author;
    }
    
    public String toCsv (){   
    return String.format("%d,%s,%s", this.ID,this.Title,this.Author) ;
    }
    
    public Book (){    }
    public Book (int id,String Title,String Author) {
    this.ID=id;
    this.Title=Title;
    this.Author=Author;
    }
    
    
    
}
