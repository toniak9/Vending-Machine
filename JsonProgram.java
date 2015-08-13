/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
              
         long calories = (long) requirements.get("calorie");
         String sugars = (String) requirements.get("sugars");
         long fats = (long) requirements.get("fat");
         Double price = (Double)requirements.get("price");
         System.out.println(requirements);

         
        List<HashMap> reqList= new ArrayList<>();
      //  Iterator<Integer> keySetIterator = result.keySet().iterator();
        
        
        

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Sruti/Desktop/json files/Food.json"));

            JSONObject jsonObject = (JSONObject) obj;
            
            JSONObject food = (JSONObject) jsonObject.get("Food");
            JSONObject snack = (JSONObject) food.get("Snacks");
            JSONObject chips = (JSONObject) snack.get("Chips");
            
            JSONArray items = (JSONArray)chips.get("items");
            List k = new ArrayList<>();
            for(int i=0; i<items.size(); i++){
                HashMap result = new HashMap<>();

                JSONObject nutrition = (JSONObject)items.get(i);
                Double jsonCost = (Double) nutrition.get("cost");
                
                JSONObject jsonNutritionalFacts =(JSONObject) nutrition.get("nutritionalFacts");
                long jsonCalorieCount = (long)jsonNutritionalFacts.get("calorieCount");
                String jsonSugar = (String) jsonNutritionalFacts.get("sugars");
                long jsonFat = (long) jsonNutritionalFacts.get("fat");
                System.out.println("JSON values:"+jsonCalorieCount+" "+jsonSugar+" "+jsonFat+" "+jsonCost);
                System.out.println("1: " + (jsonCalorieCount <= calories));
                System.out.println("2: " + (sugars.equals(jsonSugar)));
                System.out.println("sugars:" + sugars +":" + " jsonSugsrs:" +jsonSugar +":");
                System.out.println("3: " + (jsonFat <= fats));
                System.out.println("4: " + (jsonCost <= price));
            
                if((jsonCalorieCount <= calories) && (sugars.equals(jsonSugar)) && (jsonFat <= fats) && (jsonCost <= price)){
                    //System.out.println("JSON values:"+jsonCalorieCount+" "+jsonSugar+" "+jsonFat);
                    System.out.println("requirements matched");
                    long itemCode = (Long) nutrition.get("code");
                    String itemName = (String) nutrition.get("name");
                    double itemCost = (Double) nutrition.get("cost");
                    System.out.println("result list: "+itemCode+" "+itemName+" "+itemCost);
                    result.put("itemCode", itemCode);
                    result.put("itemName", itemName);
                    result.put("itemCost", itemCost);
                    System.out.println(result);
                    reqList.add(i, result);
                    System.out.println(reqList);
                    
                   
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
         
             
           System.out.println(reqList);
            new CartGUI(reqList).setVisible(true);
     }
}
 

