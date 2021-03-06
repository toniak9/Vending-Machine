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
import java.util.Map;
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
interface JSONProgramInterface {
         public void foodParser(HashMap req);
     }
public class JsonProgram implements JSONProgramInterface {
     @Override
     public void foodParser(HashMap requirements) {
         long calories = 0;
         String sugars = null;
         long fats = 0;
         Double price = null; 
         List foodType = new ArrayList();
         JSONDataAccess dataAccess = new ConcreteJSONDataAccess();
          Iterator it = requirements.entrySet().iterator();
          while (it.hasNext()) {
               Map.Entry pair = (Map.Entry)it.next();
               if(pair.getKey() == "calorie") {
                   calories = (long) requirements.get("calorie");
               }
               if(pair.getKey() == "sugars") {
                   sugars = (String) requirements.get("sugars");
               }
               if(pair.getKey() == "fat") {
                   fats = (long) requirements.get("fat");
               }
               if(pair.getKey() == "price") {
                   price = (Double)requirements.get("price"); 
               }
               if(pair.getKey() == "foodType"){
                   foodType = (List) requirements.get("foodType");
               }
          }

        List<HashMap> reqList= new ArrayList<>();
            JSONObject jsonObject = dataAccess.openFile("SanJoseVMFood.json");
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems"); 
            int index=0;
            if(foodType.isEmpty() == false) {
                // get the user selected requirements in foodType list
            for(int i=0; i< foodType.size(); i++){ 
                String getFoodType = (String)foodType.get(i);
                //iterate through the json file to compare with the food items
                for(int k=0; k<foodItems.size(); k++){
                    
                    JSONObject jsonFoodType = (JSONObject) foodItems.get(k);
                    String jsonItemType = (String) jsonFoodType.get("itemType");
                    
                    if(jsonItemType.compareTo(getFoodType)==0){
                        JSONArray items = (JSONArray)jsonFoodType.get("items");
                        //get the items in selected food type and iterate through them
                        for(int j=0; j<items.size(); j++) {
                            HashMap result = new HashMap<>();
                            JSONObject itemDetails = (JSONObject)items.get(j);
                            Double jsonCost = (Double) itemDetails.get("cost");
                            JSONObject jsonNutritionalFacts =(JSONObject) itemDetails.get("nutritionalFacts");
                            long jsonCalorieCount = (long)jsonNutritionalFacts.get("calorieCount");
                            String jsonSugar = (String) jsonNutritionalFacts.get("sugars");
                            long jsonFat = (long) jsonNutritionalFacts.get("fat");
                            //check for the user requiremts for calories, sugars, fat etc.
                            boolean a = ((calories == 0) ? true : (jsonCalorieCount <= calories));
                            boolean b = (null == sugars) ? true : (sugars.equalsIgnoreCase(jsonSugar));
                            boolean c = (fats == 0) ? true : (jsonFat <= fats);
                            boolean d = (price == null) ? true : (jsonCost <= price);
                            if(a && b && c && d) {
                                long itemCode = (Long) itemDetails.get("code");
                                String itemName = (String) itemDetails.get("name");
                                double itemCost = (Double) itemDetails.get("cost");
                                result.put("itemCode", itemCode);
                                result.put("itemName", itemName);
                                result.put("itemCost", itemCost);
                                result.put("itemCalories", jsonCalorieCount);
                                result.put("itemSugars", jsonSugar);
                                result.put("itemFat", jsonFat);
                                if(!result.isEmpty()) {
                                    AbstractResult r =  new RealResult(result);
                                    result =r.getResult();
                                    reqList.add(index, result);
                                    index++;
                                } else {
                                    AbstractResult r = new NullResult();
                                    r.getResult();
                                }   
                            }
                        }
                    } else {
                           System.out.println(" NO Data");
                    }               
                } 
            }
        } else{
            for(int i=0; i<foodItems.size(); i++){
                JSONObject jsonFoodType = (JSONObject)foodItems.get(i);
                JSONArray items = (JSONArray)jsonFoodType.get("items");

                for(int j=0; j<items.size(); j++){
                    HashMap result = new HashMap<>();
                    JSONObject itemDetails = (JSONObject)items.get(j);
                    Double jsonCost = (Double) itemDetails.get("cost");

                    JSONObject jsonNutritionalFacts =(JSONObject) itemDetails.get("nutritionalFacts");
                    long jsonCalorieCount = (long)jsonNutritionalFacts.get("calorieCount");
                    String jsonSugar = (String) jsonNutritionalFacts.get("sugars");
                    long jsonFat = (long) jsonNutritionalFacts.get("fat");
                   
                     boolean a = ((calories == 0) ? true : (jsonCalorieCount <= calories));
                     boolean b = (null == sugars) ? true : (sugars.equals(jsonSugar));
                     boolean c = (fats == 0) ? true : (jsonFat <= fats);
                     boolean d = (price == null) ? true : (jsonCost <= price);
                     if(a && b && c && d) {
                        long itemCode = (Long) itemDetails.get("code");
                        String itemName = (String) itemDetails.get("name");
                        double itemCost = (Double) itemDetails.get("cost");
                        result.put("itemCode", itemCode);
                        result.put("itemName", itemName);
                        result.put("itemCost", itemCost);
                        result.put("itemCalories", jsonCalorieCount);
                        result.put("itemSugars", jsonSugar);
                        result.put("itemFat", jsonFat);
                        if(!result.isEmpty()) {
                            AbstractResult r =  new RealResult(result);
                            result =r.getResult();
                            reqList.add(index, result);
                            index++;
                        } else {
                            AbstractResult r = new NullResult();
                            r.getResult();
                        }   
                    }
                }
            }
        }
        new CartGUI(reqList).setVisible(true);
    }
}

abstract class AbstractResult {
     long itemCode;
     String itemName;
     double itemCost;
     long jsonCalorieCount;
     String jsonSugar;
     long jsonFat;
                
                  
    
     HashMap resultMap = new HashMap<>();;
     public abstract boolean isNil();
     public abstract HashMap getResult();
}

class RealResult extends AbstractResult {

   public RealResult(HashMap result) {
       /*this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.jsonCalorieCount = jsonCalorieCount;
        this.jsonSugar = jsonSugar;
        this.jsonFat = jsonFat;*/
       this.resultMap = result;
        
   }
   
   @Override
   public boolean isNil() {
      return false;
   }

    @Override
    public HashMap getResult() {
        /*resultMap.put("itemCode", itemCode);
        resultMap.put("itemName", itemName);
        resultMap.put("itemCost", itemCost);
        resultMap.put("itemCalories", jsonCalorieCount);
        resultMap.put("itemSugars", jsonSugar);
        resultMap.put("itemFat", jsonFat);*/
                 
        return resultMap;//"Succesful";
   }
}

class NullResult extends AbstractResult {

   @Override
   public HashMap getResult() {
      return null;//"Not Available in Customer Database";
   }

   @Override
   public boolean isNil() {
      return true;
   }
}







