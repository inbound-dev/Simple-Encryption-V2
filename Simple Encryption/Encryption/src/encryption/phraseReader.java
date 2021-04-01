/*
 * 
 * 
 * 
 */
package encryption;

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
            File file = new File("C:\\Users\\jordan\\Desktop\\Simple Encryption\\Encryption\\Phrase.txt");
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

