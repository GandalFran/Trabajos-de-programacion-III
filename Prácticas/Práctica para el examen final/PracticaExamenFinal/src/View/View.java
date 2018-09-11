/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Otros.Enums.tipoSortMedico;
import static Otros.Enums.tipoSortMedico.especialidad;
import static Otros.Enums.tipoSortMedico.planta;
import Otros.Enums.tipoSortPaciente;
import static Otros.Enums.tipoSortPaciente.DNI;
import static Otros.Enums.tipoSortPaciente.ultimoIngreso;
import Otros.Exceptions.SortNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author franp
 */
public class View {

    public View(){
        importarPacientes();
    }
    
    private Controller c = new Controller();
    private Scanner sc = new Scanner(System.in);
    
    public void runMenu(String[]menus){
        boolean salir = false;
        String respuesta;
        
        do{
            System.out.println(menus[0]);
            respuesta = sc.nextLine();
            switch(respuesta){
                case "0": nuevoPaciente(); break;
                case "1": nuevoMedico(); break;
                case "2": nuevoIngreso(); break;
                case "3": exportarPacientes(); break;
                case "4": ordenarPacientes(menus[1]); break;
                case "5": ordenarMedicos(menus[2]); break;
                case "s": salir = true; break;
                default: System.err.println("ERROR: alerta por subnormal que no sabe pulsar la tecla decuada"); break;
            }
        }while(!salir);
    }

    public void nuevoPaciente(){
        String[]data = new String[3];
        System.out.print("Introduzca apellido 1:");
        data[1] = sc.nextLine();
        System.out.print("Introduzca apellido 2:");
        data[2] = sc.nextLine();
        System.out.print("Introduzca nombre:");
        data[0] = sc.nextLine();
        c.addPaciente(data);
    }
    
    public void nuevoMedico(){
        String[]data = new String[4];
        System.out.print("Introduzca apellidos:");
        data[0] = sc.nextLine();
        System.out.print("Introduzca nombre:");
        data[1] = sc.nextLine();
        System.out.print("Introduzca especialidad:");
        data[2] = sc.nextLine();
        System.out.print("Introduzca planta:");
        data[3] = sc.nextLine();
        c.addMedico(data);
    }

    private void nuevoIngreso(){
        String[]data = new String[3];
        do{
            System.out.print("Introduzca dni del paciente: ");
            data[0] = sc.nextLine();
            if(!c.existePaciente(Integer.parseInt(data[0]))){
                String respuesta;
                System.out.println("ERROR: el paciente no esta registrado\n¿Introducir otro paciente? (S/N)");
                do{respuesta = sc.nextLine();}while(!"sSnN".contains(respuesta));
                if(respuesta.equalsIgnoreCase("N")) return;
            }
        }while(!c.existePaciente(Integer.parseInt(data[0])));
        
        do{
            System.out.print("Introduzca codigo del medico: ");
            data[1] = sc.nextLine();
            if(!c.existePaciente(Integer.parseInt(data[1]))){
                String respuesta;
                System.out.println("ERROR: el medico no esta registrado\n¿Introducir otro medico? (S/N)");
                do{respuesta = sc.nextLine();}while(!"sSnN".contains(respuesta));
                if(respuesta.equalsIgnoreCase("N")) return;
            }
        }while(!c.existePaciente(Integer.parseInt(data[1])));
        
        System.out.print("Introduzca causa de ingreso: ");
        data[2] = sc.nextLine();
        c.addIngreso(data);
    }
    
    private void exportarPacientes(){
        try{
            c.exportarPacientes();
        }catch(IOException e){
            System.err.println("Los pacientes no pudieron ser importados; saliendo del programa");
            System.exit(-1);
        };
    }
    private void importarPacientes(){
        try{
            c.importarPacientes();
        }catch(IOException e){
            System.err.println("Los pacientes no pudieron ser importados; saliendo del programa");
            //System.exit(-1);
        };
    }
    private void ordenarPacientes(String menu){
        System.out.println(menu);
        try{
            switch(sc.nextLine()){
                case "1": c.ordenarPacientes(DNI); break;
                case "2": c.ordenarPacientes(tipoSortPaciente.ApellidosYNombre); break;
                case "3": c.ordenarPacientes(ultimoIngreso); break;
                default: System.err.println("ERROR: alerta por subnormal que no sabe pulsar la tecla decuada"); break;
            }
        }catch(SortNotFoundException e){
            System.out.println("ERROR: el criterio de ordenacion ofrecido no esta soportado por el sistema");
        }
    }
    private void ordenarMedicos(String menu){
        System.out.println(menu);
        try{
            switch(sc.nextLine()){
                case "1": c.ordenarMedicos(especialidad); break;
                case "2": c.ordenarMedicos(tipoSortMedico.ApellidosYNombre); break;
                case "3": c.ordenarMedicos(planta); break;
                default: System.err.println("ERROR: alerta por subnormal que no sabe pulsar la tecla decuada"); break;
            }
        }catch(SortNotFoundException e){
            System.out.println("ERROR: el criterio de ordenacion ofrecido no esta soportado por el sistema");
        }
    }
    
}
