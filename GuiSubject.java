/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sruti
 */
public class GuiSubject {
    
    /*private VendingMachineGUI gui;
    private CalorieCountGUI guiCC;*/
    private String calories;
    private String sugars;
    private String fat;
    private String price;
    private String snacks = null;
    private String candies = null;
    private String beverages = null;
    
    public GuiSubject() {
        
    }
    
    
     public void setCalories(String calories){
         this.calories = calories;
     }
     
     public  void setSugars(String sugars){
         this.sugars = sugars;
     }
     
     public  void setFat(String fat){
         this.fat = fat;
     }
     
     public  void setPrice(String price){
         this.price = price;
     }
     
     public  void setSnacks(String snacks){
         this.snacks = snacks;
     }
     
     public  void setCandies(String candies){
         this.candies = candies;
     }
     
     public  void setBeverages(String beverages){
         this.beverages = beverages;
     }
     
     public String getCalories() {
         return calories;
     }
     
     public String getSugars() {
         return sugars;
     }
     
     public String getFat() {
         return fat;
     }
     
     public String getPrice() {
         return price;
     }
     
     public String getSnacks() {
         return snacks;
     }
     
     public String getCandies() {
         return candies;
     }
     
     public String getBeverages() {
         return beverages;
     }
     
     private List<Requirements> requirements = new ArrayList<Requirements>();
     
    public void attach(Requirements requirement){
        requirements.add(requirement);		
   }
    
    
   public void notifyObserver(boolean[] array) {
       

       if(array[0] == true) {
           Requirements r = new CalorieReq(this);
           requirements.get(0).update(calories);
            System.out.println("Calories Content is :"+getCalories());
       }
       if(array[1] == true) {
           Requirements r = new SugarReq(this);
           requirements.get(1).update(sugars);
           System.out.println("Sugars Content is :"+getSugars());
       }
       if(array[2] == true) {
           Requirements r = new FatReq(this);
           requirements.get(2).update(fat);
           System.out.println("Fat Content is :"+getFat());
       }
       if(array[3] == true) {
           Requirements r = new PriceReq(this);
           requirements.get(3).update(price);
           System.out.println("Price is :"+getPrice());
       }
       if(array[4] == true) {
           if(snacks != null) {
            Requirements r = new SnackFoodTypeReq(this);
            requirements.get(4).update(snacks);
             System.out.println("Food Type is "+getSnacks());
        }
        if(candies != null) {
           Requirements r = new CandyFoodTypeReq(this);
           requirements.get(5).update(candies);
           System.out.println("Food Type is "+getCandies());
        }
        if(beverages != null) {
            Requirements r = new BeverageFoodTypeReq(this);
            requirements.get(6).update(beverages);
            System.out.println("Food Type is "+getBeverages());  
        }
       } 
    
       
       for(int i = 0; i < requirements.size(); i++)
      requirements.get(i).display();
      
       Requirements a = new ConcreteRequirements();
       
    }
}
