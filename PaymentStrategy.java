/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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
     
     public String doOperation(double totalPrice, double coinsEntered, double num3); 
     public void updateQuantity(HashMap quantity, double price);
}

class OperationCoinsVerify implements PaymentStrategy{
    
   public String doOperation(double num1, double num2, double num3) {
        double a;
       if(num1 == num2) {
           return "coins matched";
       } else if(num1 < num2) {
           a = num2 - num1;
           return "your change $"+a+" is returned";
       } else if(num1 > num2) {
           return "Please add more coins";
       } else {
           return "do nothing";
       }
   }

    @Override
    public void updateQuantity(HashMap quantity, double price) {
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/SanJoseVMFood.json"));
            JSONObject jsonObject = (JSONObject) obj;
            double amount = (double) jsonObject.get("Amount");
            jsonObject.put("Amount", amount+price);
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            
            for(int i=0; i<quantity.size(); i++){
                long itemCode = (long) quantity.get("itemCode");
                
                for(int j=0; j<foodItems.size(); j++){
                    
                    JSONObject foodObject = (JSONObject) foodItems.get(j);
                    JSONArray items = (JSONArray) foodObject.get("items");
                    
                    for(int k=0; k< items.size(); k++){
                        JSONObject itemsObject = (JSONObject) items.get(k);
                   
                        if(itemCode == (long)itemsObject.get("code")){
                            long itemCount = (long) quantity.get("itemCount");
                            long jsonItemCount = (long) itemsObject.get("count");
                            if((jsonItemCount-itemCount)>0)
                                itemsObject.put("count", jsonItemCount-itemCount);
                            System.out.println("new item count is put");
                        } 
                    }
                }    
            }
            System.out.println("Food items"+ foodItems);
            File file=new File("/Users/Tonia/Desktop/SanJoseVMFood.json");   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
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
                  
                  if((cardNumber == (long)num2) && (accessCode == (long)num3)){
                    double balance = (double) cardDetailsObject.get("balance");
                    balance -= num1;
                    cardDetailsObject.put("balance", balance);
                    System.out.println("balance is "+balance);
                    message = new String("Transaction Successful"); 
                    System.out.println("message"+ message);
                    break;
                  } else {
                     message = new String("Not a valid user");
                     break;
                    } 
              }
            File file=new File("/Users/Tonia/Desktop/cardDetails.json");   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(OperationCardVerify.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(OperationCardVerify.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ParseException ex) {
              Logger.getLogger(OperationCardVerify.class.getName()).log(Level.SEVERE, null, ex);
          }
          return message;
   }

    @Override
    public void updateQuantity(HashMap quantity, double price) {
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/SanJoseVMFood.json"));
            JSONObject jsonObject = (JSONObject) obj;
            double amount = (double) jsonObject.get("Amount");
            jsonObject.put("Amount", amount+price);
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            
            for(int i=0; i<quantity.size(); i++){
                long itemCode = (long) quantity.get("itemCode");
                
                for(int j=0; j<foodItems.size(); j++){
                    
                    JSONObject foodObject = (JSONObject) foodItems.get(j);
                    JSONArray items = (JSONArray) foodObject.get("items");
                    
                    for(int k=0; k< items.size(); k++){
                        JSONObject itemsObject = (JSONObject) items.get(k);
                   
                        if(itemCode == (long)itemsObject.get("code")){
                            long itemCount = (long) quantity.get("itemCount");
                            long jsonItemCount = (long) itemsObject.get("count");
                            if((jsonItemCount-itemCount)>0)
                                itemsObject.put("count", jsonItemCount-itemCount);
                            itemsObject.put("count", itemCount);
                            System.out.println("new item count is put");
                        } 
                    }
                }    
            }
            System.out.println("Food items"+ foodItems);
            File file=new File("/Users/Tonia/Desktop/SanJoseVMFood.json");   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

class Context {
   private PaymentStrategy strategy;

   public Context(PaymentStrategy strategy){
      this.strategy = strategy;
   }

   public String executeStrategy(double price, double cardNum, double accessCode, HashMap quantity){
       strategy.updateQuantity(quantity,price);
       return strategy.doOperation(price, cardNum, accessCode);
      
   }
}
