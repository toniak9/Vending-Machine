/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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
public class JsonProgram {
     public void foodParser(HashMap requirements) throws IOException {
        
         int calories = (int) requirements.get("calorie");
    
         String sugars = (String) requirements.get("sugars");
         int fats = (int) requirements.get("fat");
         Double price = (Double)requirements.get("price");
         System.out.println(requirements);
       //  Hashmap<> result = new Hashmap<>(); 
         
         //Double price = Double.parseDouble(requirements.get("price"));
         //String foodType = requirements.get("foodtype"); 

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/Food.json"));

            JSONObject jsonObject = (JSONObject) obj;
            
            JSONObject food = (JSONObject) jsonObject.get("Food");
            JSONObject snack = (JSONObject) food.get("Snacks");
            JSONObject chips = (JSONObject) snack.get("Chips");
            
            JSONArray items = (JSONArray)chips.get("items");
          
            for(int i=0; i<items.size(); i++){
                JSONObject nutrition = (JSONObject)items.get(i);
                Double cost = (Double) nutrition.get("cost");
                JSONObject nutritionalFacts =(JSONObject) nutrition.get("nutritionalFacts");
                String calorieCount = nutritionalFacts.get("calorieCount").toString();
                String sugar = (String) nutritionalFacts.get("sugars");
                String fat = nutritionalFacts.get("fat").toString();
               
             /*   long cal = (Long) nutritionalFacts.get("calorieCount");
                System.out.println("this is cal value printing now in integers"+cal); */
            
                if((calories <= Integer.parseInt(calorieCount)) && (sugars.equals(sugar)) && (fats <= Integer.parseInt(fat)) && (price <= cost)){
                    System.out.println("requirements matched");
                    long itemCode = (Long) nutrition.get("code");
                    String itemName = (String) nutrition.get("name");
                    double itemCost = (Double) nutrition.get("cost");
                    System.out.println("result list"+itemCode+" "+itemName+" "+itemCost);
                    
                } else {
                    System.out.println("No options available for your selelction");
                }
               
                
                
            }
            
     
           
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
    }

    
     }
}
 

