/*
 * this is an encryption program, this is intended to turn words/sentances 
 * into strings of characters that seem unitleigible
 */
package encryption;
import java.util.Random;
import java.io.File;  
import java.io.*;  
import java.util.Scanner;
/**
 *
 * @author jordan
 */
public class Encryption {
    public static void main(String[] args){
         Writer();
    }
    public static void Writer(){ 
        try{
        String str = "";
        BufferedWriter writer = new BufferedWriter(new FileWriter("EncryptedMessage.txt"));
        writer.write(encryption());
    
        writer.close();
        System.exit(0);
        }
        catch(IOException e){
            System.out.println("An Error Occoured");
        }
    }
    public static String encryption(){
            String alphabet[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            String alphabetCaps[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
            String phrase;
            String newPhrase = "";
        
            phraseReader read = new phraseReader();
            phrase = read.reader();
            
            Random randint = new Random();
            
            int phraseLength = phrase.length();
            int characterAssinments[] = new int[phraseLength];
            
            // detecting the spot in the arrays where the letters are located and assining them a numerical value
            for(int i = 0; i <= phraseLength - 1; i++){
                for(int j = 0; j <= 25; j++){
                    String letter = Character.toString(phrase.charAt(i));
                    if(letter.equals(alphabetCaps[j])){
                        characterAssinments[i] = j;
                        System.out.println("This Letter is: " + characterAssinments[i]);
                    }
                    if(letter.equals(alphabet[j])){
                        characterAssinments[i] = j;
                        System.out.println("This Letter is: " + characterAssinments[i]);
                    }
                }
            }
            int factor = randint.nextInt(38);
            
            System.out.println("The Current Shifting Factor is: " + (factor));
            
            // shifing the arrays to make the old letters into mumbo jumbo
            if(factor > 0){
                for(int j = 0; j <= phraseLength - 1; j++){
                    if((characterAssinments[j] + factor ) >= 26){
                        characterAssinments[j] = characterAssinments[j] + factor - 26;
                        //System.out.println("The Current Factor is: " + factor);
                    }
                    else{
                        characterAssinments[j] += factor;
                        //System.out.println("The Current Factor is: " + factor);
                    }
                }
             
            // adding the new characters to the new phrase
            for(int i = 0; i<= phraseLength - 1; i++){
                //System.out.println(characterAssinments[i]);
                if((characterAssinments[i] - 1) >= 0){
                    String currentLetter = alphabet[characterAssinments[i] - 1];
                    newPhrase += currentLetter;
                }
                else{
                    String currentLetter = alphabet[25];
                    newPhrase += currentLetter;
                }
            }
            //System.out.println(newPhrase);
            return newPhrase;    
        }
        else{
            return phrase;
        }
    }
}
