/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Tonia
 */
/**
 * This class is used to parse the JSON file and display the food items 
 * depending the user selected vending machine
 * Strategy pattern is applied here to filter the list of items based on 
 * different categories selected.
 *
 */
public class PieChartController {
        private PieChart view;
        private PieChartModel model;
        private String filename;
        
    public PieChartController(PieChart view, PieChartModel model) {
        this.view = view;
        this.model = model;   
    }
    
    public int getTotalSnackCount() {
        return model.getSnackCount();
    }
    public int getTotalBeverageCount() {
        return model.getBeverageCount();
    }
    public int getTotalCandiesCount() {
        return model.getCandiesCount();
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public void updateView() {
        model.parseItems(filename);
        view.piechartValues(getTotalSnackCount(), getTotalBeverageCount(), getTotalCandiesCount());
    }
    
   /* public static void main(String args[]){
        JSONParser parser = new JSONParser();
        parser.parseItems();
    }*/
}
