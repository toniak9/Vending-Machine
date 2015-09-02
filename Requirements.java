/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Sruti
 */
public interface Requirements {
    HashMap selectedReq = new HashMap<>();
    public JsonProgram parser = new JsonProgram();
    public void update(String req);
    public int display();  
}
class ConcreteRequirements implements Requirements{
    ConcreteRequirements(){
        super();
        parser.foodParser(selectedReq);
    }
    public void update(String req){}
    public int display(){
        return 0;
    }
    
}
interface RequirementsDecorator extends Requirements {
    public void update(String req);
    public int display();  
}

class CalorieReq implements RequirementsDecorator{
    
    long calories;
    GuiSubject subject;
    public CalorieReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    
    public void update(String req) {
        calories = Long.parseLong(req);
        selectedReq.put("calorie", calories);
  //      System.out.println("Hashmap value calories"+selectedReq.get("calorie"));
        
    }
    
    public int display() {
       System.out.println("calories in req class Content is :"+calories);
        return 10;
    }
}


class SugarReq implements RequirementsDecorator {
    String sugars;
    GuiSubject subject;
    public SugarReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        sugars = req;
        //adding vlaue to hashmap
        selectedReq.put("sugars", sugars);
    //    System.out.println("Hashmap value sugars"+selectedReq.get("sugars"));
        
    }
    
    public int display() {
       System.out.println("sugars in req class Content is :"+sugars);
        return 100;
    }
}


class FatReq implements RequirementsDecorator {
    long fat;
    GuiSubject subject;
    public FatReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        
        fat = Long.parseLong(req);
        
        selectedReq.put("fat", fat);
   //     System.out.println("Hashmap value fat"+selectedReq.get("fat"));
        
    }
    
    public int display() {
       System.out.println("fat in req class Content is :"+fat);
        return 100;
    }
}

class PriceReq implements RequirementsDecorator {
    double price;
    GuiSubject subject;
    public PriceReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
       
        price = Double.parseDouble(req);
       
        
        selectedReq.put("price", price);
    //    System.out.println("Hashmap value price"+selectedReq.get("price"));
    }
    
    public int display() {
        System.out.println("price in req class Content is :"+price);
        return 100;
    }
}

abstract class FoodTypeReq implements RequirementsDecorator {
    
    
  /*  GuiSubject subject;
    public FoodTypeReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }*/
    
    
    List foodType = new ArrayList();
    
    abstract public void update(String req);
    abstract public int display(); 
    abstract public String getType(); 
   
 }

    class CompositeFoodType extends FoodTypeReq {
        
    public void update(String req) {
         selectedReq.put("foodType", foodType);
    }
    public void add(FoodTypeReq food ){
        foodType.add(food.getType());
    }
    
    public void remove(FoodTypeReq food ){
        System.out.println("food removed from list");
    }
     
    public int display() {
         System.out.println("foodtype in req class Content is :");
        return 1;
    }
    public String getType(){
        return null;
    }
}
    class SnackFoodTypeReq extends FoodTypeReq {
        String snackType;
        
        GuiSubject subject;
        SnackFoodTypeReq(GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
        
        public void update(String req) {
        snackType = req;
        
    }
    
    public int display() {
        System.out.println("foodtype in req class Content is :"+snackType);
        return 1;
    }
    public String getType(){
        return "Snacks";
    }
    
 }

class CandyFoodTypeReq extends FoodTypeReq {
        String candyType;
        
        GuiSubject subject;
        CandyFoodTypeReq(GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
        
        public void update(String req) {
        candyType = req;
       // foodType.add(candyType);
      //  selectedReq.put("foodtype", foodType);
        
    }
    
    public int display() {
        System.out.println("foodtype in req class Content is :"+candyType);
        return 1;
    }
    public String getType(){
        return "Candies";
    }
    
 }

class BeverageFoodTypeReq extends FoodTypeReq {
        String beverageType;
        
        GuiSubject subject;
        BeverageFoodTypeReq(GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
        
        public void update(String req) {
        beverageType = req;
       // foodType.add(beverageType);
       // selectedReq.put("foodtype");
        
    }
    
    public int display() {
        System.out.println("foodtype in req class Content is :"+beverageType);
        return 1;
    }
    public String getType(){
        return "Beverages";
    }
    
 }
  
