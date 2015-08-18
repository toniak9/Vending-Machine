/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Tonia
 */
public class LoginValidation {
    
    public String setFields(String username, String password){
        System.out.println("In validation class"+ username+"---"+password);
        String message = null;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Sruti/Desktop/json files/loginDetails.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray loginID = (JSONArray) jsonObject.get("Login IDs");
            System.out.println(loginID);
            for(int i=0; i<loginID.size(); i++){
                JSONObject loginObject = (JSONObject) loginID.get(i);
                String jsonUsername = (String) loginObject.get("username");
                String jsonPassword = (String) loginObject.get("password");
                if((username.equals(jsonUsername)) && (password.equals(jsonPassword))){
                    message = "successful";
                    break;
                } else {
                    message = "unsuccessful";
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LoginValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
}
