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
           CompositeFoodType compositeFood = new CompositeFoodType();
           if(snacks != null) {
            Requirements snack = new SnackFoodTypeReq(this);
            compositeFood.add((FoodTypeReq) snack);
        }
        if(candies != null) {
           Requirements candy = new CandyFoodTypeReq(this);
            compositeFood.add((FoodTypeReq) candy);
        }
        if(beverages != null) {
            Requirements beverages = new BeverageFoodTypeReq(this);
            compositeFood.add((FoodTypeReq) beverages);
        }
        compositeFood.update(null);
       } 
    
       
       for(int i = 0; i < requirements.size(); i++)
      requirements.get(i).display();
      
       Requirements a = new ConcreteRequirements();
       
    }
}
