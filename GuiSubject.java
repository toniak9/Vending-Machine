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
    private String foodType;
    
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
     
     public  void setFoodType(String foodType){
         this.foodType = foodType;
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
     
     public String getFoodType() {
         return foodType;
     }
     
     private List<Requirements> requirements = new ArrayList<Requirements>();
     
    public void attach(Requirements requirement){
        requirements.add(requirement);		
   }
    
    
   public void notifyObserver(boolean[] array) {
       
/*	Iterator<Requirements> it = requirements.iterator();
        System.out.println("Hai");
		while (it.hasNext()) {
			Requirements requirement = it.next();
                        if(array[0] == true) {
			requirement.update(calories);
                        System.out.println("Hai2");
                        } 
                        if(array[1] == true) {
                            requirement.update(sugars);
                            System.out.println("Sugars Content is :"+getSugars());
                        }
                        if(array[2] == true) {
                            requirement.update(fat);
                          System.out.println("Fat Content is :"+getFat());
                        }
                          if(array[3] == true) {
                              requirement.update(price);
                            System.out.println("Price is :"+getPrice());
                        }
                        if(array[4] == true) {
                            requirement.update(foodType);
                            System.out.println("Food Type is "+getFoodType());
                        } 
                }
	}*/
     
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
           Requirements r = new FoodTypeReq(this);
           requirements.get(4).update(foodType);
           System.out.println("Food Type is "+getFoodType());
       }  
       
       
       for(int i = 0; i < requirements.size(); i++)
      requirements.get(i).display();
      
       Requirements a = new ConcreteRequirements();
    }
}
