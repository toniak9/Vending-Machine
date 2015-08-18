package projectvendingmachine;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.TableView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
/**
 * State Pattern is applied in this class
 * Role interface is the state; AdminRole and ManagerRole are 
 * different states depending on the user login
 * @AdminRole has limited view; cannot perform actions like introducing new items, 
 * deleting existing ones
 */
public interface Role {
   public void restockAction(List<HashMap> itemsChanged);
}

class AdminRole implements Role {
    @Override
    public void restockAction(List<HashMap> itemsChanged) {
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/Food.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            
            for(int i=0; i<itemsChanged.size(); i++){
                HashMap itemsSummary = itemsChanged.get(i);
                int itemCode = (int) itemsSummary.get("itemCode");
                
                for(int j=0; j<foodItems.size(); j++){
                    
                    JSONObject foodObject = (JSONObject) foodItems.get(i);
                    JSONArray items = (JSONArray) foodObject.get("items");
                    
                    for(int k=0; k< items.size(); k++){
                        JSONObject itemsObject = (JSONObject) items.get(k);
                   
                        if(itemCode == (long)itemsObject.get("code")){
                            int itemCount = (int) itemsSummary.get("itemCount");
                            itemsObject.put("count", itemCount);
                            System.out.println("new item count is put");
                        }
                    }
                }
                
            }
            System.out.println("Food items"+ foodItems);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
}

class ManagerRole implements Role {
 
    @Override
    public void restockAction(List<HashMap> itemsChanged) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String args[]){
        Role admin = new AdminRole();
        HashMap items = new HashMap<>();
        items.put("itemCode", 101);
        items.put("itemCount", 6);
        List<HashMap> itemsChanged = new ArrayList<>();
        itemsChanged.add(items);
        
        admin.restockAction(itemsChanged);
        
    }
}
