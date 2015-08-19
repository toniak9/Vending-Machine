/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Tonia
 */
/**
 * This class is used to parse the JSON file and display the food items 
 * depending the user selected vending machine
 * Strategy pattern is applied here to filter the list of items based on 
 * different categories selected.
 *
 */
public class JSONParser {
    public void parseItems(){
        
        int snackTotalCount = 0;
        int beveragesTotalCount =0;
        int candiesTotalCount =0;
        
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/Food.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            
            for(int i=0; i<foodItems.size(); i++){ 
                JSONObject foodObject = (JSONObject) foodItems.get(i);
                JSONArray items = (JSONArray) foodObject.get("items");
                
                if(((String)foodObject.get("itemType")).equalsIgnoreCase("snacks")){
                    for(int j=0; j<items.size(); j++) {
                        JSONObject itemObject = (JSONObject) items.get(j);
                        long itemCount = (Long) itemObject.get("count");
                        snackTotalCount += itemCount;
                    
                }
                }
                if(((String)foodObject.get("itemType")).equalsIgnoreCase("beverages")){
                    for(int j=0; j<items.size(); j++) {
                        JSONObject itemObject = (JSONObject) items.get(j);
                        long itemCount = (Long) itemObject.get("count");
                        beveragesTotalCount += itemCount;
                    
                }
                }
                if(((String)foodObject.get("itemType")).equalsIgnoreCase("candies")){
                    for(int j=0; j<items.size(); j++) {
                        JSONObject itemObject = (JSONObject) items.get(j);
                        long itemCount = (Long) itemObject.get("count");
                        candiesTotalCount += itemCount;
                    
                }
                } 
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
       // new AdminLoginGUI(itemSummary).setVisible(true);

    }
}
