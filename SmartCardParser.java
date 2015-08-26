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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Tonia
 */
public class SmartCardParser {
    private double balance;
    private String cardType;
    JSONDataAccess dataAccess;
    
    public void setBalance(double balance, String cardType) {
        this.balance = balance; 
        if(this.balance == 10.0)
            this.cardType = "Smart10";
        if(this.balance == 20.0)
            this.cardType = "Smart20";
        if(this.balance == 50.0)
            this.cardType = "Smart50";
    }
    
    public void decrementCount(){
        CardIterator cardIterator;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/SanJoseVMFood.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray cardItemsArray = (JSONArray) jsonObject.get("CardItems");
            
            for(int i=0; i<cardItemsArray.size(); i++) {
                JSONObject cardObject = (JSONObject) cardItemsArray.get(i);
                String itemType = (String) cardObject.get("itemType");
                JSONArray itemsArray = (JSONArray) cardObject.get("items");
                cardIterator = new CardIterator(itemsArray);
                    
                for(Iterator iter = cardIterator.getIterator();iter.hasNext();) {
                    JSONObject itemObject = (JSONObject) iter.next();
                    String jsonCardType = (String) itemObject.get("name");
                    if(jsonCardType.equalsIgnoreCase(cardType)){
                        long count = (long) itemObject.get("count");
                        count = count - 1;
                        itemObject.put("count", count);
                        break;
                        }
                    }
            }
            File file=new File("/Users/Tonia/Desktop/SanJoseVMFood.json");   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SmartCardParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SmartCardParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SmartCardParser.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void addCard(){
        CardIterator cardIterator;
        try {
            
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/cardDetails.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray cardDetails = (JSONArray) jsonObject.get("cardDetails"); 
            JSONObject cardInfo = new JSONObject();
            //cardIterator = new CardIterator(cardDetails);
            Random r = new Random( System.currentTimeMillis() );
                long rand5 = 10000 + r.nextInt(20000);
                long rand3 = 100 + r.nextInt(900);
                cardInfo.put("cardNumber",rand5);
                cardInfo.put("accessCode",rand3);
                cardInfo.put("balance",balance);
                cardDetails.add(cardInfo);
            
            File file=new File("/Users/Tonia/Desktop/CardDetails.json");   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
            
        } catch (IOException ex) {
            Logger.getLogger(SmartCardParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SmartCardParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[]) {
        SmartCardParser parser = new SmartCardParser();
        parser.setBalance(30.0, "Smart10");
        //parser.addCard();
        parser.decrementCount();
    }
  
    
}
