/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Alumno;
import Model.Constantes;
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
    
    
    public void generateRandomListOfStudents(){
        m.generateRandomListOfAlumnos();
    }
    
    public int exportData(String rutaHtml, String rutaDel){
        File fHtml = new File(rutaHtml);
        File fDel = new File(rutaDel);
        
        List <String> aEscribirHtml = m.generateHtmlCode();
        List <String> aEscribirDel = m.generateTabbedCode();
        
        try{
            Files.deleteIfExists(fHtml.toPath());
            Files.write(fHtml.toPath(),aEscribirHtml);
        }catch(IOException e){
           return -1;
        }
        
        try{
            Files.deleteIfExists(fDel.toPath());
            Files.write(fDel.toPath(),aEscribirDel);
        }catch(IOException e){
            return -1;
        }
        
        return 0;
    }
    
    public String getDataTable(){
        return m.generateDataTable();
    }
    public String getAssistancetable(float tasaMinima){
        return m.generateAssistanceDatatable(tasaMinima);
    }
    
    
}
