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
 interface FoodInfo {
   public String getFoodType();
}

interface Snacks extends FoodInfo {
    public String getFoodType();
    public String getItemId();
    public double getItemCost();
    
}

class Chips implements Snacks {
   public String getFoodType() {
       return "Chips of type Snacks";
    }
    public String getItemId(){
        return "Chips1";
    }
    public double getItemCost(){
        return 2.0;
    }
}


class Biscuits implements Snacks {
  public String getFoodType() {
       return "Biscuits of type Snacks";
    }
    public String getItemId(){
        return "Biscuites1";
    }
    public double getItemCost(){
        return 1.5;
    }  
}

interface Candy extends FoodInfo {
    public String getFoodType();
    public String getItemId();
    public double getItemCost();
    
}

class BarCandies implements Candy {
   public String getFoodType() {
       return "Bars of type Candies";
    }
    public String getItemId(){
        return "Candy1";
    }
    public double getItemCost(){
        return 1.0;
    }  
}

interface Beverages extends FoodInfo {
    public String getFoodType();
    public String getItemId();
    public double getItemCost();
    
}

class SoftDrinks implements Beverages {
    public String getFoodType() {
       return "SoftDirnks of type Beverages";
    }
    public String getItemId(){
        return "SoftDrinks1";
    }
    public double getItemCost(){
        return 3.0;
    } 
}


class FoodFactory {
    public static FoodInfo createFood(String foodType) {
        if(foodType.equals("Snacks")){
            return new Chips();
        } else if(foodType.equals("Candy")){
            return new BarCandies();
        } else if(foodType.equals("Beverages")){
            return new SoftDrinks();
        }else {
            throw new IllegalArgumentException("No such food Item");
        }
    }
}


public class Food {
    public static void main(String args[]) {
              String foodType = "Candy";
              FoodInfo fd = FoodFactory.createFood(foodType);
              System.out.println(fd.getFoodType());

    }

} 