/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabetletternumbers;
import java.util.Scanner;
/**
 *
 * @author jordan
 */
public class AlphabetLetterNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String alphabet[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String alphabetCaps[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        String character;
        
        Scanner scanner  = new Scanner(System.in);
        
        
        int Letter[] = new int[1];
        
        System.out.println("What Letter Do You Want The Numerical Value For: ");
        
        character = scanner.next();
            
        // detecting the spot in the arrays where the letters are located and assining them a numerical value    
        for(int j = 0; j <= 25; j++){
            String letter = Character.toString(character.charAt(0));
            if(letter.equals(alphabetCaps[j])){
                Letter[0] = j;
                System.out.println("This Letter is: " + Letter[0]);
            }
            if(letter.equals(alphabet[j])){
                Letter[0] = j;
                System.out.println("This Letter is: " + Letter[0]);
            }
        }
            
    }
    
}
