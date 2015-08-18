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
        HashMap summary;
        List<HashMap> itemSummary = new ArrayList<>(); 
        
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Sruti/Desktop/json files/Food.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            
            for(int i=0; i<foodItems.size(); i++){ 
                JSONObject foodObject = (JSONObject) foodItems.get(i);
                JSONArray items = (JSONArray) foodObject.get("items");
                
                for(int j=0; j<items.size(); j++) {
                    summary = new HashMap<>();
                    JSONObject itemObject = (JSONObject) items.get(j);
                    String itemName = (String) itemObject.get("name");
                    Double itemCost = (Double) itemObject.get("cost");
                    long itemCode = (Long) itemObject.get("code");
                    String itemCategory = (String) itemObject.get("category");
                    long itemCount = (Long) itemObject.get("count");
                    // put the item list into summary HashMap
                    
                    summary.put("itemCode", itemCode);
                    summary.put("itemName", itemName);
                    summary.put("itemCategory", itemCategory);
                    summary.put("itemCost",itemCost);
                    summary.put("itemCount",Long.toString(itemCount));
                    
                    // put each item (table row) in a list and pass the list to 
                    itemSummary.add(summary);    
                }    
            }
            System.out.println(itemSummary);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        new AdminLoginGUI(itemSummary).setVisible(true);
    }
    
    public static void main(String args[]){
        JSONParser itemParser = new JSONParser();
        itemParser.parseItems();
    }
}
