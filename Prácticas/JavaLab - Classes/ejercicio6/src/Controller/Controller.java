/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Constantes;
import Model.DatosDeAlumno;
import Model.DatosDireccion;
import Model.DatosPersonales;
import Model.Model;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franp
 */
public class Controller {
    
    private final Model m = new Model();
    
    public void generateRandomListOfStudents(int numAlumnos){
        m.generateRandomListOfStudents(numAlumnos);
        
    }
    
    public String writePersonalDataTable(String ruta){
        String msg="Los datos fueron guardados de forma satisfactoria";
       
        List<String> aEscribir = m.generatePersonalDataTable();
        
        File f = new File(ruta);
        try{
            Files.deleteIfExists(f.toPath());
            Files.write(f.toPath(),aEscribir);
        }catch(IOException e){
            msg="ERROR: no se pudo acceder al fichero " + ruta + ".\nPruebe otra vez.";
        }
        
        return msg;
    }
    public String writeAdressDataTable(String ruta) {
        String msg="Los datos fueron guardados de forma satisfactoria";
       
        List<String> aEscribir = m.generateAdressTable();
        
        File f = new File(ruta);
        try{
            Files.deleteIfExists(f.toPath());
            Files.write(f.toPath(),aEscribir);
        }catch(IOException e){
            msg="ERROR: no se pudo acceder al fichero " + ruta + ".\nPruebe otra vez.";
        }
        
        return msg;
    }    
    public String getDataTable(){
        return m.generateScreenDataTable();
    }
    
}
