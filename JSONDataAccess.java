/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Tonia
 */
public interface JSONDataAccess {
    public JSONObject openFile(String filename);
    public void writeFile(String filename, JSONObject jObject); 
}

class ConcreteJSONDataAccess implements JSONDataAccess {
    private JSONObject jsonObject;
    @Override
    public synchronized JSONObject openFile(String filename) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/Users/Tonia/Desktop/"+filename));
            jsonObject = (JSONObject) obj;
        } catch (IOException ex) {
            Logger.getLogger(ConcreteJSONDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ConcreteJSONDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonObject;
    }
    
    @Override
    public synchronized void writeFile(String filename, JSONObject jObject) {
        FileWriter fileWriter = null;   
        try {
            File file=new File("/Users/Tonia/Desktop/"+filename);
            fileWriter = new FileWriter(file);
            fileWriter.write(jObject.toJSONString()); 
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(ConcreteJSONDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(ConcreteJSONDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
