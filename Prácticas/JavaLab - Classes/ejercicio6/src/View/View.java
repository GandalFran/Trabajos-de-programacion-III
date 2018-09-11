/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Constantes;
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
                    c.generateRandomListOfStudents(Constantes.NUM_ALUMNOS);
                    break;
                case(2):
                    sacarResultadosPantalla();
                    break;
                case(3):
                    exportPersonalData();
                    break;
                case(4):
                    exportAdressData();
                    break;
                case(5):
                    salir=true;
                    break;
            }
        }while(salir == false);
    }
    
    
    private void sacarResultadosPantalla(){
        String toPrint = c.getDataTable();
        System.out.println(toPrint);
    }
    
    private void exportPersonalData(){
        String ruta = System.getProperty("user.home") + "/Desktop/Datos.html";
        String result=c.writePersonalDataTable(ruta);
        System.out.println(result);
    }
    
    private void exportAdressData(){
        String ruta = System.getProperty("user.home") + "/Desktop/Direcciones.html";
        String result=c.writeAdressDataTable(ruta); 
        System.out.println(result);
    }

    
}