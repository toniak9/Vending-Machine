/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Sruti
 */
public class JsonProgram {
     public void foodParser() throws IOException {

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Sruti/Desktop/json files/Food.json"));

		JSONObject jsonObject = (JSONObject) obj;
            
           // JSONObject jsonObj = (JSONObject) ;
            JSONObject food = (JSONObject) jsonObject.get("Food");
            JSONObject snack = (JSONObject) food.get("Snacks");
            JSONObject chips = (JSONObject) snack.get("Chips");
            
     
            System.out.println(chips.get("SnackID").toString()); 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
    }

    
     }
     public static void main(String[] args){
         JsonProgram js = new JsonProgram();
         try {
             js.foodParser();
         } catch (IOException ex) {
             Logger.getLogger(JsonProgram.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
 

