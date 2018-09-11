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
    
    public String loadDataFromFile(String ruta){
        String msg = "\nLa lectura del archivo se realizo con exito";
       
        File f = new File(ruta);
        List<String>lineas = null;
        try{
            lineas = Files.readAllLines(f.toPath());
        }catch(IOException e){
            msg = "\nERROR al leer el archivo " + ruta ;
            return msg;
        }
        
        String msg2 = m.generatePersonasFromTabbed(lineas);
        
        return msg + msg2;
    }

    public String getDataTable(){
        return m.generateDataTable();
    }

    
}
