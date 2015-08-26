package projectvendingmachine;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
public interface Role{
   
   public void restockAction(List<HashMap> itemsChanged);
   public void addItem(HashMap addItem);
   public void deleteItem(long code);
   public void addAdmin(String username,String password);
   public void setFilename(String filename);
   
}

class AdminRole implements Role {
    private String filename;
    
    @Override
    public void setFilename(String filename){
        this.filename = filename;    
    }
    @Override
    public synchronized void restockAction(List<HashMap> itemsChanged) {
        System.out.println("Items passed"+ itemsChanged);
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/"+filename));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            JSONArray cardItems = (JSONArray) jsonObject.get("CardItems");
            
            for(int i=0; i<itemsChanged.size(); i++){
                HashMap itemsSummary = itemsChanged.get(i);
                long itemCode = (long) itemsSummary.get("itemCode");
                
                for(int j=0; j<foodItems.size(); j++){
                    
                    JSONObject foodObject = (JSONObject) foodItems.get(j);
                    JSONArray items = (JSONArray) foodObject.get("items");
                    
                    for(int k=0; k< items.size(); k++){
                        JSONObject itemsObject = (JSONObject) items.get(k);
                   
                        if(itemCode == (long)itemsObject.get("code")){
                            long itemCount = (long) itemsSummary.get("itemCount");
                            itemsObject.put("count", itemCount);
                            System.out.println("new item count is put");
                        } else {
                            System.out.println("In else part:"+ itemCode);
                            for(int l=0; l<cardItems.size(); l++){
                                JSONObject cardObject = (JSONObject) cardItems.get(l);
                                JSONArray cardItemsArray = (JSONArray) cardObject.get("items");
                                for(int m=0; m< cardItemsArray.size(); m++){
                                    JSONObject cardItemsObject = (JSONObject) cardItemsArray.get(m);
                                    
                                    if(itemCode == (long)cardItemsObject.get("code")){
                                        long itemCount = (long) itemsSummary.get("itemCount");
                                        cardItemsObject.put("count", itemCount);
                                        System.out.println("card new item count is put");
                                    }
                                }
                            }   
                        }
                    }
                }    
            }
            System.out.println("Food items"+ foodItems);
            File file=new File("/Users/Tonia/Desktop/"+filename);   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}

    @Override
    public void addItem(HashMap addItemMap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItem(long code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAdmin(String username,String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class ManagerRole implements Role {
    private String filename;
    
    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }
 
    @Override
    public void restockAction(List<HashMap> itemsChanged) {
        System.out.println("Items passed"+ itemsChanged);
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/"+filename));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            
            for(int i=0; i<itemsChanged.size(); i++){
                HashMap itemsSummary = itemsChanged.get(i);
                long itemCode = (long) itemsSummary.get("itemCode");
                
                for(int j=0; j<foodItems.size(); j++){
                    
                    JSONObject foodObject = (JSONObject) foodItems.get(j);
                    JSONArray items = (JSONArray) foodObject.get("items");
                    
                    for(int k=0; k< items.size(); k++){
                        JSONObject itemsObject = (JSONObject) items.get(k);
                   
                        if(itemCode == (long)itemsObject.get("code")){
                            long itemCount = (long) itemsSummary.get("itemCount");
                            double itemCost = (double) itemsSummary.get("itemCost");
                            itemsObject.put("count", itemCount);
                            itemsObject.put("cost", itemCost);
                            System.out.println("new item count is put");
                        }
                    }
                }
                
            }
            System.out.println("Food items"+ foodItems);
            File file=new File("/Users/Tonia/Desktop/"+filename);   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    @Override
    public synchronized void addItem(HashMap addItem) {
        
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/"+filename));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            String itemType = (String) addItem.get("itemType");
            
            for(int i=0; i<foodItems.size(); i++){
                JSONObject foodObject = (JSONObject) foodItems.get(i);
                String jsonItemType = (String) foodObject.get("itemType");
                
                if(jsonItemType.equalsIgnoreCase(itemType)){
                    JSONArray items = (JSONArray) foodObject.get("items");
                    JSONObject itemObj = new JSONObject();  
                    itemObj.put("name", addItem.get("name"));  
                    itemObj.put("category", addItem.get("category"));  
                    itemObj.put("code", addItem.get("code"));
                    itemObj.put("cost", addItem.get("cost"));
                    itemObj.put("count", addItem.get("count"));
                    
                    JSONObject nutritionObj = new JSONObject();
                    nutritionObj.put("calorieCount", addItem.get("calorieCount"));
                    nutritionObj.put("sugars", addItem.get("sugars"));
                    nutritionObj.put("protein", addItem.get("protein"));
                    nutritionObj.put("fat", addItem.get("fat"));
                    
                    itemObj.put("nutritionalFacts", nutritionObj);
                    items.add(itemObj);
                    System.out.println("items: "+items);
                    break;
                }
            }
 
            File file=new File("/Users/Tonia/Desktop/"+filename);   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public synchronized void deleteItem(long code) {
        System.out.println("Item is deleted");
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/"+filename));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray foodItems = (JSONArray) jsonObject.get("FoodItems");
            
                for(int j=0; j<foodItems.size(); j++){
                    
                    JSONObject foodObject = (JSONObject) foodItems.get(j);
                    JSONArray items = (JSONArray) foodObject.get("items");
                    
                    for(int k=0; k< items.size(); k++){
                        JSONObject itemsObject = (JSONObject) items.get(k);
                   
                        if(code == (long)itemsObject.get("code")){
                            itemsObject.clear();
                            break;
                        }
                    }
                }
                
            System.out.println("Food items"+ foodItems);
            File file=new File("/Users/Tonia/Desktop/"+filename);   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    
    public void addAdmin(String username,String password) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/loginDetails.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray loginID = (JSONArray) jsonObject.get("Login IDs");
            JSONObject loginObject = new JSONObject();
            loginObject.put("username", username);
            loginObject.put("password", password);
            loginObject.put("role", "admin");
            loginID.add(loginObject);
            System.out.println(loginID);    
         
            File file=new File("/Users/Tonia/Desktop/loginDetails.json");   
            FileWriter fileWriter = new FileWriter(file);  
            fileWriter.write(jsonObject.toJSONString());  
            fileWriter.flush();  
            fileWriter.close(); 
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(LoginValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LoginValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
