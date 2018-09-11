/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author franp
 */
public class Controller {
    
    private Model m = new Model();
    
    public int exportDataHTML(String ruta){
        File f = new File(ruta);
        List <String> aEscribir = m.generateHTMLDataTable();
        
        try {
            Files.deleteIfExists(f.toPath());
            Files.write(f.toPath(), aEscribir);
        } catch (IOException ex) {
            return -1;
        }
        return 0;
    }
    
    public String getDataTable(){
        return m.generateStringDatatable();
    }
    
    public void setRandomValues(){
        m.generateRandomValues();
    }
    
    public void importDataFromKeyboard(float[][]precios,int[][]ventas){
        m.saveDataFromKeyBoard(precios,ventas);
    }

}
