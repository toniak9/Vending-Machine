/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

/**
 *
 * @author Sruti
 */
public interface PaymentStrategy {
     public String doOperation(double num1, double num2); 
}

class OperationCoinsVerify implements PaymentStrategy{
  
   public String doOperation(double num1, double num2) {
        double a;
       if(num1 == num2) {
           return "coins matched";
       } else if(num1 < num2) {
           a = num1 - num2;
           return "your change is returned";
       } else if(num1 > num2) {
           a = num2 - num1;
           return "Please add more coins";
       } else {
           return " do nothing";
       }
   }
}


class OperationCardVerify implements PaymentStrategy{
   @Override
   public String doOperation(double num1, double num2) {
      if(num1 == num2) {
           return "Transaction Successful";
       } else {
           return "Not a valid user";
       } 
   }
}


class Context {
   private PaymentStrategy strategy;

   public Context(PaymentStrategy strategy){
      this.strategy = strategy;
   }

   public String executeStrategy(double num1, double num2){
       return strategy.doOperation(num1, num2);
      
   }
}
