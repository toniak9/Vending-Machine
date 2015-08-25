/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import org.json.simple.JSONArray;

/**
 *
 * @author Tonia
 */

interface Iterator {
   public boolean hasNext();
   public Object next();
}

interface Container {
   public Iterator getIterator();
}

public class CardIterator implements Container {
   public JSONArray card = new JSONArray();
   
   public CardIterator(JSONArray card) {
       this.card = card;
       System.out.println("Card details"+card);
   }

   @Override
   public Iterator getIterator() {
      return new cardDetailsIterator();
   }

   private class cardDetailsIterator implements Iterator {

      int index = 0;

      @Override
      public boolean hasNext() {
          System.out.println("card size"+card.size());
         if(index < card.size()){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return card.get(index++);
         }
         return null;
      }		
   }
}
