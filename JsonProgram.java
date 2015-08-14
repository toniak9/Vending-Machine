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
public class JsonProgram {
     public void foodParser(HashMap requirements) throws IOException {
         long calories = 0;
         String sugars = null;
         long fats = 0;
         Double price = null; 
         List foodType = new ArrayList();
          
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

    
         System.out.println(requirements);
       List<HashMap> reqList= new ArrayList<>();
      //  Iterator<Integer> keySetIterator = result.keySet().iterator();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/Food.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONObject food = (JSONObject) jsonObject.get("Food");

            int k=0;
            //if(foodType != null){       
            for(int j=0; j< foodType.size(); j++){
                
                String getFoodType = (String)foodType.get(j);
                System.out.println(getFoodType);
                JSONObject jsonFoodType = (JSONObject) food.get(getFoodType);
                JSONArray items = (JSONArray)jsonFoodType.get("items");
                System.out.println(items);
                
                 for(int i=0; i<items.size(); i++){
                    HashMap result = new HashMap<>();
                    JSONObject itemDetails = (JSONObject)items.get(i);
                    Double jsonCost = (Double) itemDetails.get("cost");

                    JSONObject jsonNutritionalFacts =(JSONObject) itemDetails.get("nutritionalFacts");
                    long jsonCalorieCount = (long)jsonNutritionalFacts.get("calorieCount");
                    String jsonSugar = (String) jsonNutritionalFacts.get("sugars");
                    long jsonFat = (long) jsonNutritionalFacts.get("fat");
                    System.out.println("JSON values:"+jsonCalorieCount+" "+jsonSugar+" "+jsonFat+" "+jsonCost);
                    System.out.println("1: " + (jsonCalorieCount <= calories));
                    System.out.println("2: " + (jsonSugar.equals(sugars)));
                    System.out.println("sugars:" + sugars +":" + " jsonSugsrs:" +jsonSugar +":");
                    System.out.println("3: " + (jsonFat <= fats));
    //                System.out.println("4: " + (jsonCost <= price));

                     boolean a = ((calories == 0) ? true : (jsonCalorieCount <= calories));
                     boolean b = (null == sugars) ? true : (sugars.equals(jsonSugar));
                     boolean c = (fats == 0) ? true : (jsonFat <= fats);
                     boolean d = (price == null) ? true : (jsonCost <= price);
                     if(a && b && c && d) {
                   // if((jsonCalorieCount <= calories) && (sugars.equals(jsonSugar)) && (jsonFat <= fats) && (jsonCost <= price)){
                        //System.out.println("JSON values:"+jsonCalorieCount+" "+jsonSugar+" "+jsonFat);
                        System.out.println("requirements matched");
                        long itemCode = (Long) itemDetails.get("code");
                        String itemName = (String) itemDetails.get("name");
                        double itemCost = (Double) itemDetails.get("cost");
                        System.out.println("result list: "+itemCode+" "+itemName+" "+itemCost);
                       /*       result.put("itemCode", itemCode);
                    result.put("itemName", itemName);
                    result.put("itemCost", itemCost);
                    result.put("itemCalories", jsonCalorieCount);
                    result.put("itemSugars", jsonSugar);
                    result.put("itemFat", jsonFat);
                    System.out.println(result);  */
                    RealResult r =  new RealResult(itemCode,itemName,itemCost,jsonCalorieCount,jsonSugar,jsonFat);
                    
                        result =r.getResult();
                        reqList.add(k, result);
                        k++;
                        System.out.println(reqList);

                } else {
                  /* NullResult n = new NullResult();
                   System.out.println(" "+n.getResult());*/
                     System.out.println(" NO Data");
                }
                
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

    RealResult() {
        
    }
   public RealResult(long itemCode, String itemName, double itemCost, long jsonCalorieCount, String jsonSugar, long jsonFat) {
      	this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.jsonCalorieCount = jsonCalorieCount;
        this.jsonSugar = jsonSugar;
        this.jsonFat = jsonFat;
        
   }
   
   @Override
   public boolean isNil() {
      return false;
   }

    @Override
    public HashMap getResult() {
        resultMap.put("itemCode", itemCode);
        resultMap.put("itemName", itemName);
        resultMap.put("itemCost", itemCost);
        resultMap.put("itemCalories", jsonCalorieCount);
        resultMap.put("itemSugars", jsonSugar);
        resultMap.put("itemFat", jsonFat);
                 
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







