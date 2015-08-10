/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

/**
 *
 * @author Sruti
 */
public interface Requirements {
    public void update(String req);
    public int display();
    
}

class CalorieReq implements Requirements {
    
    String calories;
    GuiSubject subject;
    public CalorieReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    
    public void update(String req) {
        calories = req;
        
    }
    
    public int display() {
       System.out.println("calories in req class Content is :"+calories);
        return 10;
    }
}


class SugarReq implements Requirements {
    String sugars;
    GuiSubject subject;
    public SugarReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        sugars = req;
    }
    
    public int display() {
       System.out.println("sugars in req class Content is :"+sugars);
        return 100;
    }
}


class FatReq implements Requirements {
    String fat;
    GuiSubject subject;
    public FatReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        fat = req;
        
    }
    
    public int display() {
       System.out.println("fat in req class Content is :"+fat);
        return 100;
    }
}

class PriceReq implements Requirements {
    String price;
    GuiSubject subject;
    public PriceReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        price = req;
        
    }
    
    public int display() {
        System.out.println("price in req class Content is :"+price);
        return 100;
    }
}

class FoodTypeReq implements Requirements {
    String foodType;
    GuiSubject subject;
    public FoodTypeReq (GuiSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(String req) {
        foodType = req;
        
    }
    
    public int display() {
        System.out.println("foodtype in req class Content is :"+foodType);
        return 100;
    }
}