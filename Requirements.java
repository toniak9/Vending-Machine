/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author Sruti
 */
public interface Requirements {
    HashMap<String,String> selectedReq = new HashMap<>();
    public JsonProgram parser = new JsonProgram();
    public void update(String req);
    public int display();  
}
class ConcreteRequirements implements Requirements{
    ConcreteRequirements(){
        super();
        try {
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
    
    String calories;
    GuiSubject subject;
    public CalorieReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    
    public void update(String req) {
        calories = req;
        selectedReq.put("calorie", calories);
        
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
        selectedReq.put("calorie", sugars);
        //System.out.println("Hashmap value"+selectedReq.get("calorie"));
        
    }
    
    public int display() {
       System.out.println("sugars in req class Content is :"+sugars);
        return 100;
    }
}


class FatReq implements RequirementsDecorator {
    String fat;
    GuiSubject subject;
    public FatReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        fat = req;
        selectedReq.put("fat", fat);
        
    }
    
    public int display() {
       System.out.println("fat in req class Content is :"+fat);
        return 100;
    }
}

class PriceReq implements RequirementsDecorator {
    String price;
    GuiSubject subject;
    public PriceReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        price = req;
        selectedReq.put("price", price);
        
    }
    
    public int display() {
        System.out.println("price in req class Content is :"+price);
        return 100;
    }
}

class FoodTypeReq implements RequirementsDecorator {
    String foodType;
    GuiSubject subject;
    public FoodTypeReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        foodType = req;
        selectedReq.put("foodtype", req);
        
    }
    
    public int display() {
        System.out.println("foodtype in req class Content is :"+foodType);
        return 100;
    }
}