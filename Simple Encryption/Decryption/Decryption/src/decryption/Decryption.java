/*
 * This is the decryption side of the program
 * This side takes what appears to be uniteligible text
 * and converts it to the original message using a key
 */
package decryption;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author jordan
 */
public class Decryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Writer();
        
    }
    // this is resposible for writing the contents of the decryption algo to the text file
    public static void Writer(){ 
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("DecryptedMessage.txt"));
        writer.write(Decrypt());
    
        writer.close();
        
        }
        catch(IOException e){
            System.out.println("An Error Occoured");
        }
        System.exit(0);
    }
    public static String Decrypt(){
        String alphabet[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String alphabetCaps[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        String originalPhrase = "";
        
        JFrame window = new JFrame("Key 1");

        window.setVisible(true);
        
        int shiftFactor = Integer.parseInt(JOptionPane.showInputDialog(window, "shift Factor"));
        
        phraseReader read = new phraseReader();
        String Phrase = read.reader();
        
        int phraseLength = Phrase.length();
        int characterAssinments[] = new int[phraseLength];
        
        // detecting what space in the array any perticual letter is in
        for(int i = 0; i <= phraseLength - 1; i++){
                for(int j = 0; j <= 25; j++){
                    String letter = Character.toString(Phrase.charAt(i));
                    if(letter.equals(alphabetCaps[j])){
                        characterAssinments[i] = j;
                        //System.out.println("This Letter is: " + characterAssinments[i]);
                    }
                    if(letter.equals(alphabet[j])){
                        characterAssinments[i] = j;
                        //System.out.println("This Letter is: " + characterAssinments[i]);
                    }
                }
            }
        // shifing the arrays to make the mumbo jumbo into the original message
        for(int i = 0; i <= phraseLength - 1; i++){
               if((characterAssinments[i] - (shiftFactor)) < 0){ 
                    characterAssinments[i] = characterAssinments[i] - (shiftFactor - 1) + 26;
                    //System.out.println("This Letter is: " + characterAssinments[i]);
                }
                else{
                    characterAssinments[i] -= (shiftFactor - 1);
                    //System.out.println("This Letter is: " + characterAssinments[i]); 
            }
        }
        //setting the new characters to the String
        for(int i = 0; i<= phraseLength - 1; i++){
                //System.out.println(characterAssinments[i]);
                if((characterAssinments[i] - 1) >= 0){
                    String currentLetter = alphabet[characterAssinments[i]];
                    originalPhrase += currentLetter;
                }
                else{
                    String currentLetter = alphabet[25];
                    originalPhrase += currentLetter;
                }
            }
     
        System.out.println(originalPhrase);
        return originalPhrase;
    }
}
