/*************************************************************************************
 * Name: Pedro Antonio Alarcon
 * Project 2, Due: 01/20/2020 
 *************************************************************************************/

import java.util.Scanner; 

 /*************************************************************************************
 * The class SecretMessage repeatedly asks a user whether they would like to:
 *          1: encode a message
 *          2: decode a message
 *          3: quit the program
 * Inputs are case sensitive, meaning capitalization of a character is preserved
 * Accepts numbers and other characters but are not encoded/decoded. Only letters. 
 *************************************************************************************/
public class SecretMessage {
    
    /*************************************************************************************
    * isLowerCaseLetter takes in a char letter and returns true 
    * if that letter is a lower case letter (between 'a' and 'z'), false otherwise
    *************************************************************************************/
    public static boolean isLowerCaseLetter(char letter){
        
        int lowerA = (int) 'a'; //97
        int lowerZ = (int) 'z'; //122
        int temp = (int) letter;
        
        return (letter >= lowerA && letter <= lowerZ); // 97 <= letter <= 122
    }
 
    /*************************************************************************************
    * isUpperCaseLetter takes in a char letter and returns true 
    * if that letter is an upper case letter (between 'A' and 'Z'), false otherwise
    *************************************************************************************/
    public static boolean isUpperCaseLetter(char letter){
        
        int upperA = (int) 'A'; //65
        int upperZ = (int) 'Z'; //90
        int temp = (int) letter;
        
        return (letter >= upperA) && (letter <= upperZ); // 65 <= letter <= 90
    }
 
 /*************************************************************************************
 * isLetter takes in a character and returns true if it is a letter
 * 
 *************************************************************************************/   
    public static boolean isLetter(char letter){
        
        return (isUpperCaseLetter(letter) || isLowerCaseLetter(letter)); // 65 <= letter <= 122
    }
 
 /*************************************************************************************
 * toLowerCase takes an upper case letter as a parameter and returns the same letter in 
 * in lower case format
 * difference between upper and lower case chars are constant 
 * a = gap + A
 *************************************************************************************/     

    public static char toLowerCase(char upperCase){
        
        int gap = 32; //diference between upper and lower chars ex. a - A = 32
        int asciilowerCase = gap + (int) upperCase;
        char lowerCase = (char) asciilowerCase;
        
        return lowerCase;     
    }
    
 /*************************************************************************************
 * toUpperCase takes a lower case letter as a parameter and returns the same letter in 
 * in upper case format
 * difference between upper and lower case chars are constant 
 * A = a - 32
 *************************************************************************************/
    public static char toUpperCase(char lowerCase){
        
        int gap = - 32; //diference between upper and lower chars ex. a - A = 32
        int asciiUpperCase = gap + (int) lowerCase;
        char upperCase = (char) asciiUpperCase;
        
        return upperCase;      
    }
    
 /*************************************************************************************
 * codeChar takes in a letter and boolean flag as parameters 
 * if flag = true -> letter is encoded, otherwise letter is decoded
 * numbers and other characters are not encoded/decoded and remain the same
 *************************************************************************************/ 
    public static char codeChar(char letter, boolean flag){
        
        int index;
        char encoded; 
        char decoded;
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String enc = "kngcadsxbvfhjtiumylzqropwe";
        
        if ( isLetter(letter) ) {
            //to encode: subtract by 'a' so that we can index strings characters
            // by using the letter param, ex. enc[letter] = letters[letter]
            if (flag == true){
                if ( isLowerCaseLetter(letter) ){ 
                    encoded = enc.charAt((int) (letter - 'a') );
                    return encoded;
                }
                else{ //if char is Upper Case, convert to lowercase then repeat above steps
                    encoded = toLowerCase(letter); 
                    encoded = enc.charAt((int) (encoded - 'a') ); 
                    return toUpperCase(encoded);  //convert back to UppperCase       
                }

             }
            //to decode: find index of char in enc, then look up same index in letters
            else {
                if (isLowerCaseLetter(letter)) {
                    index = enc.indexOf(letter);
                    decoded = letters.charAt(index);
                    return decoded;
                }
                else{
                    letter = toLowerCase(letter);
                    index = enc.indexOf(letter);
                    decoded = letters.charAt(index);                    
                    return toUpperCase(decoded);
                }
               
             } 
        }
        else{  // if number or other character, return without encoding/decoding
            return letter;
        }
        
     
      
    }
    
  /*************************************************************************************
 * takes in string s and boolean flag 
 * if flag = true, encode s then print, otherwise decode s then print
 *************************************************************************************/   
    public static void codeMessage(String s, boolean flag){
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            System.out.print( codeChar(c, flag) );
		}
    }
    
    
  /*************************************************************************************
 * Present Menu to User: 
 *  1: Encode message given by User
 *  2: Decode message given by User
 *  3: Quit
 *************************************************************************************/       
    public static void main(String[] args){
        
        int UserOption;
        System.out.print("Enter 1 to encone, 2 to decode, and 3 to quit: ");
	Scanner scan = new Scanner(System.in) ; 
        
        while ( (UserOption = scan.nextInt()) != 3) {
              
            Scanner in = new Scanner(System.in);
        
            if (UserOption == 1) {
                
                System.out.print("Enter text to encode: ");
                String[] tokens = in.nextLine().split(" "); 
                
                for (String token : tokens) {
                    codeMessage(token, true);
                    System.out.print(" ");
                }

            
            }
            else if (UserOption == 2) {
            
                System.out.print("Enter text to decode: ");
                String[] tokens = in.nextLine().split(" "); 
                
                for (String token : tokens) {
                    codeMessage(token, false);
                    System.out.print(" ");
                }
            } 
            System.out.print("\n");
            System.out.print("Enter 1 to encone, 2 to decode, and 3 to quit: ");
        
        } 
    
    }
    
}
