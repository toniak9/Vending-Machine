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
import javax.swing.text.html.HTMLEditorKit;

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
        try {
            System.out.println(selectedReq.get("calorie"));
            parser.foodParser(selectedReq);
        } catch (IOException ex) {
            Logger.getLogger(ConcreteRequirements.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    int calories;
    GuiSubject subject;
    public CalorieReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    
    public void update(String req) {
        calories = Integer.parseInt(req);
        selectedReq.put("calorie", calories);
         System.out.println("Hashmap value"+selectedReq.get("calorie"));
        
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
        System.out.println("Hashmap value"+selectedReq.get("sugars"));
        
    }
    
    public int display() {
       System.out.println("sugars in req class Content is :"+sugars);
        return 100;
    }
}


class FatReq implements RequirementsDecorator {
    int fat;
    GuiSubject subject;
    public FatReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        fat = Integer.parseInt(req);
        selectedReq.put("fat", fat);
         System.out.println("Hashmap value"+selectedReq.get("fat"));
        
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
        System.out.println("Hashmap value"+selectedReq.get("price"));
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
        foodType.add(snackType);
        selectedReq.put("foodtype", foodType);
        
    }
    
    public int display() {
        System.out.println("foodtype in req class Content is :"+snackType);
        return 1;
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
        foodType.add(candyType);
        selectedReq.put("foodtype", foodType);
        
    }
    
    public int display() {
        System.out.println("foodtype in req class Content is :"+candyType);
        return 1;
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
        foodType.add(beverageType);
        selectedReq.put("foodtype", foodType);
        
    }
    
    public int display() {
        System.out.println("foodtype in req class Content is :"+beverageType);
        return 1;
    }
    
 }
  
