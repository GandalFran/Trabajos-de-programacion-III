/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.util.Scanner;
import Model.Constantes;

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
                    imprimirAlumnos();
                    break;
                case(3):
                    imprimirAlumnosPocaAsistencia(Constantes.TASA_MINIMA);
                    break;
                case(4):
                    exportarFichero();
                    break;
                case(5):
                    salir=true;
                    break;
            }
        }while(salir == false);
    }
    
    
    private void imprimirAlumnos(){
        System.out.println(c.getDataTable());
    }
    
    private void imprimirAlumnosPocaAsistencia(float tasaMinima){
        System.out.println(c.getAssistancetable(tasaMinima));
    }
    
    private void exportarFichero(){
        String rutaEscritorio = System.getProperty("user.home");
        String rutaHtml = rutaEscritorio + "/Desktop/alumnos.html";
        String rutaDel = rutaEscritorio + "/Desktop/tabulado.txt";
        
        int resultado = c.exportData(rutaHtml,rutaDel);
        
        switch (resultado) {
            case (-1):
                System.out.println("ERROR: no se pudo acceder al archivo " + rutaHtml + ".\nPruebe otra vez.");
                break;
            case (-2):
                System.out.println("ERROR: no se pudo acceder al archivo " + rutaDel + ".\nPruebe otra vez.");
                break;
            case (0):
                System.out.println("Los datos se exportaron de forma satisficatoria");
                break;
        }

    }

    
}