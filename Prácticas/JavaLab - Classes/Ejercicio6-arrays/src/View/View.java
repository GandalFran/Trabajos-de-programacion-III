/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author franp
 */
public class View {
    
    private final Controller c = new Controller();
    private final Scanner sc = new Scanner(System.in);
    
    public void runMenu(String menuText){
        boolean salir = false;
        
        do{
            System.out.println(menuText);
            int seleccion = sc.nextInt();
            
            switch(seleccion){
            
                case(1):
                    c.generateRandomListOfStudents();
                    break;
                case(2):
                    sacarResultadosPantalla();
                    break;
                case(3):
                    sacarDatosPersonalesFichero();
                    break;
                case(4):
                    sacarDireccionesFichero();
                    break;
                case(5):
                    salir=true;
                    break;
            }
        }while(salir == false);
    }
    
    
    private void sacarResultadosPantalla(){
        System.out.println(c.generateTable());
    }
    
    private void sacarDatosPersonalesFichero(){
        String ruta = System.getProperty("user.home") + "/Desktop/DatosPersonales.html";
        File f = new File(ruta);
        
        List<String> aEscribir = c.getTablaDatosPersonales();
        
        try{
            Files.deleteIfExists(f.toPath());
            Files.write(f.toPath(),aEscribir);
        }catch(IOException e){
            System.out.println("ERROR: no se pudo acceder al fichero " + ruta + ".\nPruebe otra vez.");
        }
    }
    
    private void sacarDireccionesFichero(){
        String ruta = System.getProperty("user.home") + "/Desktop/Direcciones.html";
        File f = new File(ruta);
        
        List<String> aEscribir = c.getTablaDirecciones();
        
        try{
            Files.deleteIfExists(f.toPath());
            Files.write(f.toPath(),aEscribir);
        }catch(IOException e){
            System.out.println("ERROR: no se pudo acceder al fichero " + ruta + ".\nPruebe otra vez.");
        }
    }

    
}