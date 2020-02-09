/*************************************************************************************
* Author: Pedro Antonio Alarcon
* UID: 1722260
* Problem Coffee Mocha
* 
* 
* Program that manages coffees. 
* This algorithm repeatedly shows the user a menu to create one of the three
* mocha drinks or to print all the drinks created so far. If the user selects to 
* create a new mocha drink, the program prompts the user to enter the ingredients 
* of the selected drink. If the user selects to print the current coffees, print the 
* drink type and ingredients of each drink to the console. Creating objects for testing all 
* classes and all functions in the main function.
*************************************************************************************/
package HowToMakeCoffee;


public interface HowToMakeDrink{
    public void prepare();
}

 /*************************************************************************************
* The Mocha class implements the interface HowToMakeDrink.
* The Mocha class has three member variables: milkAmount, espressoShot, chocolateType. 
* 
 *************************************************************************************/
class Mocha implements HowToMakeDrink {
    
    protected double milkAmount;
    protected double expressoShot;
    protected String chocolateType;
    
        //Intitialize object with customized atributes
    Mocha(String chocolateType, double expressoShot, double milkAmount){
        this.chocolateType = chocolateType;
        setExpressoShot(expressoShot); 
        setMilkAmount(milkAmount); //oz
    }
    
    //getters
    public double getMilkAmount(){ return this.milkAmount; }
    
    public double getExpressoShot(){ return this.expressoShot; }
    
    public String getChocolateType(){ return this.chocolateType; }
    
    //setters 
    public void setMilkAmount(double milkAmount){
        this.milkAmount = milkAmount;
    }
    
    public void setExpressoShot(double expressoShot){
        this.expressoShot = expressoShot; 
    }
    
    /*************************************************************************************
    * The prepare function will simply print out the type of drink (CoffeeMocha) and 
    * all ingredients of the drink to the screen.
    **************************************************************************************/
    @Override
    public void prepare(){
                String recipe = "\nName: "+ getChocolateType() +" Mocha"
                + "\nIngredients:"
                + "\nChocolate Type: " + getChocolateType()
                + "\nExpresso Shots: " + getExpressoShot()
                + "\nMilk Amount: " + getMilkAmount();
        
        System.out.print(recipe);
        
    }
}

class WhiteChocolateMocha extends Mocha{
    

    
    //Intitialize object with customized atributes
    WhiteChocolateMocha(double expressoShot, double milkAmount){
       
        super("White Chocolate", expressoShot, milkAmount);

    }
    
    /*************************************************************************************
    * The prepare function will simply print out the type of drink (CoffeeMocha) and 
    * all ingredients of the drink to the screen.
    **************************************************************************************/
    @Override
    public void prepare(){

        super.prepare();
        System.out.println("\n");
        
    }
    
}

class DarkChocolateMocha extends Mocha{
    

    //Intitialize object with customized atributes
    DarkChocolateMocha(double expressoShot, double milkAmount){
        
        super("Dark Chocolate", expressoShot, milkAmount);
        
    }
    
    /*************************************************************************************
    * The prepare function will simply print out the type of drink (CoffeeMocha) and 
    * all ingredients of the drink to the screen.
    **************************************************************************************/
    @Override
    public void prepare(){
        
        super.prepare();
        System.out.println("\n");
      
    }
    
}

class PeppermintMocha extends Mocha{
    
    private double peppermintSyrupAmount;
    

    
    //Intitialize object with customized atributes
    PeppermintMocha(double expressoShot, double milkAmount, double peppermintSyrup){
        
        super("Peppermint", expressoShot, milkAmount);
        setPeppermintSyrupAmount(peppermintSyrup);
    }
    
    
    //getter
    public double getPeppermintSyrupAmount(){  return this.peppermintSyrupAmount; }
    
    //setters
    public void setPeppermintSyrupAmount(double pumpsAmount){
        this.peppermintSyrupAmount = pumpsAmount;
    }
    
    /*************************************************************************************
    * The prepare function will simply print out the type of drink (CoffeeMocha) and 
    * all ingredients of the drink to the screen.
    **************************************************************************************/
    @Override
    public void prepare(){
        
        super.prepare();
        String recipe = "\nPeppermint Syrup Amount: " + getPeppermintSyrupAmount();
        System.out.println(recipe);
        System.out.println("\n");
  
    }
    
}
