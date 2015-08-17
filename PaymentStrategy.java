/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Sruti
 */
public interface PaymentStrategy {
     public String doOperation(double num1, double num2, double num3); 
}

class OperationCoinsVerify implements PaymentStrategy{
  
   public String doOperation(double num1, double num2, double num3) {
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
   public String doOperation(double num1, double num2, double num3) {
          String message = null;
          try {
              JSONParser parser = new JSONParser();
              Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/cardDetails.json"));
              JSONObject jsonObject = (JSONObject) obj;
              JSONArray cardDetails = (JSONArray) jsonObject.get("cardDetails");
              
              for(int i=0;i<cardDetails.size();i++){
                  JSONObject cardDetailsObject = (JSONObject)cardDetails.get(i);
                  long cardNumber = (long) cardDetailsObject.get("cardNumber");
                  System.out.println("Card details"+ cardDetails);
                  long accessCode = (long) cardDetailsObject.get("accessCode");
                  if(cardNumber == (long)num1 && accessCode == (long)num2){
                    double balance = (double) cardDetailsObject.get("balance");
                    balance -= num3;
                    System.out.println("balance is "+balance);
                    message = new String("Transaction Successful"); 
                    System.out.println("message"+ message);
                    break;
                  } else {
                     message = new String("Not a valid user");
                     break;
                    } 
              }
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(OperationCardVerify.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(OperationCardVerify.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ParseException ex) {
              Logger.getLogger(OperationCardVerify.class.getName()).log(Level.SEVERE, null, ex);
          }
          return message;
   }
}


class Context {
   private PaymentStrategy strategy;

   public Context(PaymentStrategy strategy){
      this.strategy = strategy;
   }

   public String executeStrategy(double num1, double num2, double num3){
       return strategy.doOperation(num1, num2, num3);
      
   }
}
