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
    public void PrintWholeTextFile (String FileName) {
    try {
			File file = new File(String.format("%s.txt", FileName));
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
    
    
    
    
    }

