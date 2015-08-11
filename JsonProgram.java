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
     public void foodParser(HashMap<String,String> requirements) throws IOException {
        
         Integer calories = Integer.parseInt(requirements.get("calorie"));
    
         String sugars = requirements.get("sugars");
         String fat = requirements.get("fat");
         //Double price = Double.parseDouble(requirements.get("price"));
         //String foodType = requirements.get("foodtype"); 

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Sruti/Desktop/json files/Food.json"));

            JSONObject jsonObject = (JSONObject) obj;
            
     
            JSONObject food = (JSONObject) jsonObject.get("Food");
            JSONObject snack = (JSONObject) food.get("Snacks");
            JSONObject chips = (JSONObject) snack.get("Chips");
            
            JSONArray items = (JSONArray)chips.get("items");
          
            for(int i=0; i<items.size(); i++){
                JSONObject nutrition = (JSONObject)items.get(i);
                JSONObject nutritionalFacts =(JSONObject) nutrition.get("nutritionalFacts");
                String calorieCount = nutritionalFacts.get("calorieCount").toString();
            
                if(calories <= Integer.parseInt(calorieCount)){
                    System.out.println("calories match");
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
 

