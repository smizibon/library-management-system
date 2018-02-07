/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author zibon
 */
public class ReadWrite {
    
    public void WriteLineToTextFile (String LineElement,String FileName) throws FileNotFoundException, IOException{
    FileOutputStream out = null;

        try {
            
            /* opning in overwrite mode */ 
            /*// in = new FileInputStream("input.txt");
            //File fout = new File(String.format("%s.txt",FileName));
            //FileOutputStream fos = new FileOutputStream(fout);
            //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));*/
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(String.format("%s.txt",FileName), true));//opening in append mode. 
            bw.append(LineElement);
            bw.newLine();
            bw.close();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    public void PrintWholeTextFile (String fileName) {
    try {
			File file = new File(String.format("%s.txt", fileName));
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
 
    }
    public String SearchForBookByID(String searchterm,String fileName){
    boolean found=false;
    String ID=""; String Title = ""; String Author = "";
    
    try {
        Scanner x =new Scanner(new File(String.format("%s.txt", fileName)));
        x.useDelimiter("[,\n]");
    
        while (x.hasNext() && !found){
            ID= x.next();
            Title= x.next();
            Author= x.next();
            
            if (ID.equals(searchterm)) 
            {
            found = true;
            }
        }      
    }
    catch (Exception error) {
    System.err.println(error);
    }
        return String.format("%s,%s,%s",ID,Title,Author); 
    
    }
    
}
    
    
    
