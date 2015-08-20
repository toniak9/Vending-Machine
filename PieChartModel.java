package projectvendingmachine;


import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tonia
 */
public class PieChartModel {
    private int snackTotalCount;
    private int beveragesTotalCount =0;
    private int candiesTotalCount =0;
    
    public void parseItems(String filename){
   
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/"+filename));
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
            System.out.println("item counts: "+ snackTotalCount+" "+beveragesTotalCount+" "+ candiesTotalCount);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
       // new AdminLoginGUI(itemSummary).setVisible(true);

    }
    
    public int getSnackCount() {
        return snackTotalCount;
    }
    public int getBeverageCount() {
        return beveragesTotalCount;
    }
    public int getCandiesCount() {
        return candiesTotalCount;
    }
    
}
