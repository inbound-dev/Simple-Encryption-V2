/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jordan
 */
public class phraseReader {
    public String reader(){
    String phrase = "";
        
        try{
            File file = new File("C:\\Users\\jordan\\Desktop\\Simple Encryption\\Encryption\\EncryptedMessage.txt");
            Scanner reader = new Scanner(file);
            
            while(reader.hasNextLine()){
                phrase = reader.nextLine();
            }
        }
        catch(FileNotFoundException e){
            System.err.println("This file is either not in the right directory or does not exist");
        }
        return phrase;
}
}
