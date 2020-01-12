/******************************************************************************
 * CS 55 Java Programming
 * Author: Pedro Antonio Alarcon
 * UID: 1722260
 *******************************************************************************/

package com.mycompany.monthlypaymentcalc;
import java.util.Scanner;
import java.text.NumberFormat;



public class Main {
 /******************************************************************************
 * method calculates monthly payments given a rate in percent, length of loan term and initial balance
 * Monthly Payments = Principal_Payment + Interest_Payments
 * 
 * Equation: Monthly Payment = [ rate + rate/ ( [ 1 + rate ]^months - 1 )] * principal
 * where:
 *         rate = interest rate per month
 *         principal = initial loan amount
 *******************************************************************************/
    
    public static double getMonthlyPayment(double principle, double monthlyRate, int months ){
        
        double monthlyPay = ( monthlyRate + monthlyRate/( (float) 
                (Math.pow( (1 + monthlyRate ), months ) - 1) )) * principle;
        
        return monthlyPay; 
    }

 /******************************************************************************
 * Problem Approach: 
 *      We will dynamically allocate 1D arrays that quantitatively describes 
 *      the interest, principal and remaining balance at each payment period.
 *      Each element is computed utilizing a simple for lopp
 *******************************************************************************/
    public static double getArrSum(double[] arr){
        
        double sum = 0;
        
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        
        return sum;
    }
    

    
    public static void main(String[] args){
       
       
       Scanner scan = new Scanner( System.in );  
       //Currency Formatting
       NumberFormat currency = NumberFormat.getCurrencyInstance();
       
       //Obtain Loan logistics From User
       System.out.print("Enter the initial balance: ");
       double principle = scan.nextDouble();
       
       System.out.print("Enter the loan rate: ");
       double rate = scan.nextDouble();
       
       System.out.print("Enter total loan term year: " );
       int year = scan.nextInt();
       
       /*   convert entered parameters to appriape units  
            yearly rate is transformed into decimal and converted to have units 
            of month 
       */
       
       double monthlyRate = ( rate / 100 ) / 12; 
       int numberOfPayments = year * 12; //length of loan term
       double monthlyPay = getMonthlyPayment(principle, monthlyRate, numberOfPayments); //Total Payoff requires rought/y this monthly payment
       
       
 /******************************************************************************
 *      Allocates memory and initializes each element to 0
 *      Note that balanceArr has one more element than the interest and principal arrays
 *      since indexes begin at 0, incrementing arrSize by one will improve its interpretability 
 *      in subsequent computation, though at the costs of slight computational speed
 *******************************************************************************/
 
       int arrSize = numberOfPayments + 1;
       double[] interestExpenseArr = new double[arrSize];
       double[] principalPaymentsArr = new double[arrSize];
       double[] balanceArr = new double[arrSize];
       
       //define non-zero initial conditions
       balanceArr[0] = principle;
       
/******************************************************************************
 *  
 * For a particular period i:     
 *      Interest = Previous Remaining Balance * Monthly Rate
 *      Principal = Fixed Monthly Payment - Interest Portion
 *      New Balance = Current Balance - Interest 
 *
 *******************************************************************************/

       for(int i = 1; i < arrSize; i++){
           
           interestExpenseArr[i] = balanceArr[i - 1] * monthlyRate;
           principalPaymentsArr[i] = monthlyPay - interestExpenseArr[i];
           balanceArr[i] = balanceArr[i - 1] - principalPaymentsArr[i];     
       }
     
       // uses method to sum all elements of a particular arrayu
       double totalExpense = getArrSum(interestExpenseArr); //interest accrued over the loan term
       double totalPrincipalPayment = getArrSum(principalPaymentsArr); //for test purposes: should equal initial balance
       double totalPayment = totalExpense + totalPrincipalPayment; //Loan Amount + Accrued Interest

     
       
       //Display Results
       System.out.println("\nMonthly Payments are: " + currency.format(monthlyPay) );
       System.out.println("Total Payment is: " + currency.format(totalPayment) );
       System.out.println("Interest Expense is: " + currency.format(totalExpense) );
       
            
       }
       

   }
    
    



