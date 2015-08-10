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
         
         int calories = Integer.parseInt(requirements.get("calories"));
         String sugars = requirements.get("sugars");
         int fat = Integer.parseInt(requirements.get("fat"));
         Double price = Double.parseDouble(requirements.get("price"));
         String foodType = requirements.get("foodtype"); 

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Sruti/Desktop/json files/Food.json"));

            JSONObject jsonObject = (JSONObject) obj;
            
           // JSONObject jsonObj = (JSONObject) ;
            JSONObject food = (JSONObject) jsonObject.get("Food");
            JSONObject snack = (JSONObject) food.get("Snacks");
            JSONObject chips = (JSONObject) snack.get("Chips");
            
            JSONArray items = (JSONArray)chips.get("items");
            for(int i=0; i<items.size(); i++){
                JSONObject nutrition = (JSONObject)items.get(i);
                if(calories == (Integer)nutrition.get("calorieCount")){
                    System.out.println("calories match");
                }
                
            }
            
     
            System.out.println(chips.get("SnackID").toString()); 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
    }

    
     }
}
 

