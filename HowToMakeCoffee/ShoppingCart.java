/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HowToMakeCoffee;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 /*************************************************************************************
 * Repeatedly prompts Menu:
 * 
 *          1: Create White Chocolate Mocha and Stores in Array
 *          2: Create Dark Chocolate Mocha and Stores in Array
 *          3: Create Peppermint Mocha and Stores in Array
 *          4: Prints Drinks and Ingredients
 *          5: Exit the program
 * 
 *************************************************************************************/
public class ShoppingCart {
    
    /*************************************************************************************
    * validatePositiveInput() is a method to that validate if user input is a 
    * positive nonzero number. Re-prompts until user enter a valid input. 
    * method returns the validated input.
    *************************************************************************************/
    static double validatePositiveInput(String inputName){
        double number = 0;
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        
        //do-while loop executes until positive nonzero number has been entered
        while (!success) {
            
            try{
                System.out.print("Enter Amount of " + inputName + ": ");
                number = scanner.nextDouble();
                
                if (number <= 0)
                    throw new Exception("Positive Number Required");
                
                success = true;
                
            }catch(InputMismatchException e){
                String input = scanner.nextLine();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }catch(Exception exc ){
                System.out.printf("Not a positive number.\n");
            }    
        } 
        //returns input
        return number;
    
    }
    
    /*************************************************************************************
    * validateMenuEntry() returns a positive nonzero integer between 1 and 5.
    * repeatedly re-prompts user if input is not valid
    *************************************************************************************/
    static int validateMenuEntry(){
        int number;
        Scanner scanner = new Scanner(System.in);
        
        //do-while loop executes until positive nonzero number within bounds is entered
        do {
            System.out.print("Input: ");
            //while loop executes if input is not a number
            while (!scanner.hasNextInt()) { 
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
                System.out.print("Please enter a positive number: ");
            }
            number = scanner.nextInt();
        } while (number <= 0 || number > 5); 
        
        //returns input
        return number;
    }
    
    
    
    
      public static void main(String[] args){
        
        System.out.println("\nTESTING CLASSES AND FUNCTIONS");
        
        //Creating Objects to test constructores
        WhiteChocolateMocha whiteChocolate = new WhiteChocolateMocha(2,2);
        DarkChocolateMocha darkChocolate = new DarkChocolateMocha(3,3);
        PeppermintMocha peppermintMocha = new PeppermintMocha(4, 4, 4);
        Mocha mocha = new Mocha("No Chocolate", 1, 1);
        
        //Test prepare methods 
        System.out.println("\nTesting prepare() method\n");
        whiteChocolate.prepare();
        darkChocolate.prepare();
        peppermintMocha.prepare();
        mocha.prepare();
        
        //Test setters and getters
        System.out.println("\n\nTesting getters and setters\n");
        whiteChocolate.setExpressoShot(5);
        darkChocolate.setExpressoShot(6);
        peppermintMocha.setExpressoShot(7);
        
        whiteChocolate.setMilkAmount(8);
        darkChocolate.setMilkAmount(9);
        peppermintMocha.setMilkAmount(10);
        
        peppermintMocha.setPeppermintSyrupAmount(11);
        
        System.out.println("White Chocolate Mocha\nNew Expresso Shots: " 
                + whiteChocolate.getExpressoShot() + "\nNew Milk Amount: " 
                + whiteChocolate.getMilkAmount() + "\n");
        System.out.println("Dark Chocolate Mocha\nNew Expresso Shots: " 
                + darkChocolate.getExpressoShot() + "\nNew Milk Amount: " 
                + darkChocolate.getMilkAmount() + "\n" );
        System.out.println("Peppermint Mocha\nNew Expresso Shots: " 
                + peppermintMocha.getExpressoShot() + "\nNew Milk Amount: " 
                + peppermintMocha.getMilkAmount() + "\nNew Peppermint Syrup Amount: " 
                + peppermintMocha.getPeppermintSyrupAmount() );
                




        //program to display menu to user
        System.out.println("\nREAL PROGRAM BEGINS\n");
        
                //holds created objects
        ArrayList<Mocha> list = new ArrayList<>();

        // menu choices
        String menu = "Menu:\n Enter a choice (1-5):"
                + "\n1: Create a White Chocolate Mocha"
                + "\n2: Create a Dark Chocolate"
                + "\n3: Create a Peppemint Mocha"
                + "\n4: Print Created Drinks"
                + "\n5: Exit\n";

        
        double userInput;
        System.out.println(menu);

        
        //exits if user enters option 5.
        while ( (userInput = validateMenuEntry() ) != 5 ){
            
          
            //Creates a Circle Object
            if (userInput == 1){
                

                double shots = validatePositiveInput("Shots");
                double milk = validatePositiveInput("Milk");
                list.add(    new WhiteChocolateMocha(shots, milk)   ); //Drink is stored in array list
            }
            //Creates a Rectangle Object
            else if (userInput == 2){
                
                double shots = validatePositiveInput("Shots");
                double milk = validatePositiveInput("Milk");
                list.add(    new DarkChocolateMocha(shots, milk)   ); //Drink is stored in array list
            }
            //Creates a Square Object
            else if (userInput == 3){
                
                double shots = validatePositiveInput("Shots");
                double milk = validatePositiveInput("Milk");
                double peppermint = validatePositiveInput("Peppermint Syrup");

                list.add(    new PeppermintMocha(shots, milk, peppermint)   );  //Drink is stored in array list 
                
            }
            // Prints all names and areas of objects stored in array
            else if (userInput == 4){
                //iterates through array via for loop and envokes toString() method  
                System.out.println( "\nDrinks in Cart: \n" );
                
                for(int i = 0; i < list.size(); i++){
                   list.get(i).prepare();
                } 
             
            }

            System.out.print("\n");
            System.out.print(menu); 
            
        }
        
    }

    
}
