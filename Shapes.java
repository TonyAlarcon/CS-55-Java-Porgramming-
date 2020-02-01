/*
Author: Pedro Antonio Alarcon
UID: 1722260
Problem: Shapes                                                                           

This program repeatedly shows the user a menu to create one of the three main 
shapes or to print the shapes created so far. If the user selects to create a new shape, 
the program prompts the user to enter the values for the size of the selected shape. 
The shape is then stored in an array. If the user selects to print the current shapes, 
print the name and the total area of each shape to the console.

 */


import java.util.Scanner; 
import java.util.ArrayList;



 /*************************************************************************************
 * Shapes class has method getArea() which returns 0.0  derived children will 
 * overwrite the getArea() method accordingly. validatePositiveInput() method 
 * ascertains input from user is a positive number, re-prompts if otherwise. 
 *************************************************************************************/
public class Shapes {
    
    /*************************************************************************************
    * Returns area of object. This method is overwritten in derived classes
    *************************************************************************************/
    double getArea(){
        
        return 0.0;
    }
    
     /*************************************************************************************
    * validatePositiveInput() is a method to that validate if user input is a 
    * positive nonzero number. Re-prompts until user enter a valid input. 
    * method returns the validated input.
    *************************************************************************************/
    static double validatePositiveInput(){
        double number;
        Scanner scanner = new Scanner(System.in);
        
        //do-while loop executes until positive nonzero number has been entered
        do {
            System.out.print("Please enter a valid input: ");
            //while loop executes if input is not a number
            while (!scanner.hasNextDouble()) { 
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
                System.out.print("Please enter a positive number: ");
            }
            number = scanner.nextDouble();
        } while (number <= 0); 
        
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
            System.out.print("Please enter a valid input: ");
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
    
    /*************************************************************************************
    * isCapacityReached() accepts an ArrayList of Shapes and returns true if number
    * of elements in the list has reached an specific size. Otherwise, returns false.
    * Method will be used to prevent user from creating objects after a specified limit. 
    *************************************************************************************/
    static boolean isCapacityReached(ArrayList<Shapes> list){
        boolean isReached = false;
        if(list.size() == 10){
            System.out.println("Capacity Reached. Cannot Create More Objects\n");
            isReached = true;
        }
        return isReached;
    }
    
    
 /*************************************************************************************
 * Repeatedly prompts Menu:
 * 
 *          1: Create New Circle Object and Stores in Array
 *          2: Create New Rectangle Object and Stores in Array
 *          3: Create New Square Object and Stores in Array
 *          4: Prints Stored Shapes and Their Corresponding Area
 *          5: Exit the program
 * 
 *************************************************************************************/
    public static void main(String[] args){
        
        //holds created objects
        ArrayList<Shapes> list = new ArrayList<>();
        // menu choices
        String menu = "Menu:\n Enter a choice (1-5):\n 1. Create a Circle \n"
                + " 2. Create a Rectangle \n 3. Create a Square \n 4. Print Created Shapes \n"
                + " 5. Exit\n";

        
        double userInput;
        System.out.print(menu);

        
        //exits if user enters option 5.
        while ( (userInput = validateMenuEntry() ) != 5 ){
            
          
            //Creates a Circle Object
            if (userInput == 1){
                
            //If objects in array reach max, warns user and exits and reprompts menu
                if ( isCapacityReached(list) ){
                    continue;
                }    
                
                System.out.print( "\nEnter Radius of Circle. " );
                double radius = validatePositiveInput(); //validated radius
                list.add(    new Circle(radius)   );    //shape is stored in array list
            }
            //Creates a Rectangle Object
            else if (userInput == 2){
            
            //If objects in array reach max, warns user and exits and reprompts menu
                if ( isCapacityReached(list) ){
                    continue;
                } 
                
                System.out.print( "\nEnter Length of Rectangle: " );
                double l = validatePositiveInput(); //validated length
                System.out.print( "\nEnter Width of Rectangle: " );
                double w = validatePositiveInput(); //validated width
                list.add(    new Rectangle(w, l)   ); //shape is stored in array list
            }
            //Creates a Square Object
            else if (userInput == 3){
            
            //If objects in array reach max, warns user and exits and reprompts menu
                if ( isCapacityReached(list) ){
                    continue;
                } 
                
                
                System.out.print( "\nEnter Length of Square: " );
                double l = validatePositiveInput(); //validated length
                list.add(    new Square(l)   );  //shape is stored in array list 
                
            }
            // Prints all names and areas of objects stored in array
            else if (userInput == 4){
                //iterates through array via for loop and envokes toString() method  
                System.out.println( "\nAreas of Shape Created: \n" );
                for(int i = 0; i < list.size(); i++){
                    System.out.println( list.get(i).toString() );
                } 
             
            }

            System.out.print("\n");
            System.out.print(menu); 
            
        }
        
    }

}

 /*************************************************************************************
 * Circle class derived from Shapes class. It's only attribute is it's radius, must
 * be a positive double or int. 
 *************************************************************************************/

class Circle extends Shapes {
    
    private double radius;

    /* Constructor creates a circle object with positive radius */
    public Circle(double r){
        
        setRadius(r);
    }
    //setters
    /* sets radius */
    public void setRadius(double r){
        
        this.radius = (( r >=0) ? r : 0);
    }
    /* returns radius of object*/
    public double getRadius() { return radius; }
    
    /* overwritten method. calculates and returns area = [2*PI*radius^2] */
    @Override
    public double getArea(){
        
        return Math.PI * getRadius() * getRadius();
    }
    /* returns a string that specified shape of object and it's area */
    public String toString(){
        
        return "Circle with Area: " + getArea() + "\n";
                
    }    
}


 /*************************************************************************************
 * Rectangle class derived from Shapes. Attributes include the width and 
 * height which describe a rectangle object. 
 *************************************************************************************/
class Rectangle extends Shapes {
    
    private double  width;
    private double height;

    
    public Rectangle(double w, double h) {   
        setWidth(w); 
        setHeight(h); 
    }
    //setters
    public void setWidth(double w) { this.width = w;}
    
    public void setHeight(double h) { this.height = h; }
    
    //getters
    public double getWidth() { return width; }
    
    public double getHeight() { return height; }

    /* overwritten method. calculates and returns area = [w x h] */
    @Override
    public double getArea(){
        
        return width * height;
    }
    
    /* returns a string that specified shape of object and it's area */
    public String toString()
    {
       return "Rectangle with Area: " + getArea() + "\n";
             
    }
    
}

 /*************************************************************************************
 * Square class is derived from Shapes class. Attributes include the length of the 
 * sides of a square object. 
 *************************************************************************************/
class Square extends Shapes {
    
    private double length;


    
    public Square(double l) {
        
        this.length = l;
    }
    //setters
    public void setLength(double l) { this.length = l;}
    

    //getters
    public double getLength() { return length; }
    
    /* overwritten method. calculates and returns area = [length^2] */
    @Override
    public double getArea(){
        
        return length * length;
    }
    
    /* returns a string that specified shape of object and it's area */
    public String toString()
    {
       return "Square with Area: " + getArea() + "\n";
             
    }

}