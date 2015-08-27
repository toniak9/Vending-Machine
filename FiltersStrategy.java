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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Sruti
 */
public interface FiltersStrategy {
    
    List<HashMap> itemSummary = new ArrayList<>(); 
    public List doOperation(String file);
    
    
}

class ViewAllFilter implements FiltersStrategy {
    HashMap FilterSummary;
    
    
    public List doOperation(String file) {
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/"+file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            JSONArray cardItems = (JSONArray) jsonObject.get("CardItems");
            
            for(int i=0; i<foodItems.size(); i++){ 
                JSONObject foodObject = (JSONObject) foodItems.get(i);
                JSONArray items = (JSONArray) foodObject.get("items");
                
                for(int j=0; j<items.size(); j++) {
                    FilterSummary = new HashMap<>();
                    JSONObject itemObject = (JSONObject) items.get(j);
                    String itemName = (String) itemObject.get("name");
                    Double itemCost = (Double) itemObject.get("cost");
                    long itemCode = (Long) itemObject.get("code");
                    String itemCategory = (String) itemObject.get("category");
                    long itemCount = (Long) itemObject.get("count");
                    // put the item list into summary HashMap
                    
                    FilterSummary.put("itemCode", itemCode);
                    FilterSummary.put("itemName", itemName);
                    FilterSummary.put("itemCategory", itemCategory);
                    FilterSummary.put("itemCost",itemCost);
                    FilterSummary.put("itemCount",Long.toString(itemCount));
                    
                    // put each item (table row) in a list and pass the list to 
                    itemSummary.add(FilterSummary);    
                }    
            }
            
            for(int k=0; k<cardItems.size(); k++) {
                JSONObject cardObject = (JSONObject) cardItems.get(k);
                JSONArray cards = (JSONArray) cardObject.get("items");
                
                for(int l=0; l<cards.size(); l++){
                    FilterSummary = new HashMap<>();
                    JSONObject cardItemObj = (JSONObject) cards.get(l);
                    String cardName = (String) cardItemObj.get("name");
                    double cardBalance = (double) cardItemObj.get("balance");
                    long cardCount = (long) cardItemObj.get("count");
                    long itemCode = (Long) cardItemObj.get("code");
                    
                    FilterSummary.put("itemCode",itemCode);
                    FilterSummary.put("itemName", cardName);
                    FilterSummary.put("itemCategory", "SmartCal card");
                    FilterSummary.put("itemCost"," ");
                    FilterSummary.put("itemCount",Long.toString(cardCount));

                    itemSummary.add(FilterSummary);  
                }
            }
            
           
            System.out.println("Item summary " +itemSummary);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return itemSummary;
    }
}

class ItemTypeFilter implements FiltersStrategy {
    List requestedFiltersList = new ArrayList<>(); 

    public ItemTypeFilter(List requestedFiltersList) {
        this.requestedFiltersList = requestedFiltersList;
    }
    
    public List doOperation(String file) {
        HashMap FilterSummary;
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/"+file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            for(int k = 0; k < requestedFiltersList.size(); k++) {
                String itemfilter = (String)requestedFiltersList.get(k);
            for(int i=0; i<foodItems.size(); i++){ 
                JSONObject foodObject = (JSONObject) foodItems.get(i);
                String itemType = (String) foodObject.get("itemType");
                
                    if( itemfilter.equalsIgnoreCase(itemType)) {
                        JSONArray items = (JSONArray) foodObject.get("items");

                        for(int j=0; j<items.size(); j++) {
                            FilterSummary = new HashMap<>();
                            JSONObject itemObject = (JSONObject) items.get(j);
                            String itemName = (String) itemObject.get("name");
                            Double itemCost = (Double) itemObject.get("cost");
                            long itemCode = (Long) itemObject.get("code");
                            String itemCategory = (String) itemObject.get("category");
                            long itemCount = (Long) itemObject.get("count");
                            // put the item list into summary HashMap

                            FilterSummary.put("itemCode", itemCode);
                            FilterSummary.put("itemName", itemName);
                            FilterSummary.put("itemCategory", itemCategory);
                            FilterSummary.put("itemCost",itemCost);
                            FilterSummary.put("itemCount",Long.toString(itemCount));

                            // put each item (table row) in a list and pass the list to 
                            itemSummary.add(FilterSummary);    
                        } 
                    }
                }
                
            }
            System.out.println(itemSummary);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return itemSummary;
    }
    
}


 class FilterContext {
   private FiltersStrategy strategy;
   private String filename;

   public FilterContext(FiltersStrategy strategy, String filename){
      this.strategy = strategy;
      this.filename = filename;
   }

   public List executeStrategy(){
      return strategy.doOperation(filename);
   }
}


