/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.Controller;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import otros.Constantes;
import static otros.TipoSort.antiguedad;
import static otros.TipoSort.apellidosNombre;
import static otros.TipoSort.salario;

/**
 *
 * @author franp
 */
public class View {
    private Scanner sc = new Scanner(System.in);
    private Controller c = new Controller();
    
    public void runMenu(String menu){
        boolean salir = false;
        String respuesta;
        
        do{
            System.out.println(menu);
            respuesta = sc.nextLine();
            
            switch(respuesta){
                case "1": annadirTrabajador();   break;
                case "2": editarTrabajador();    break;
                case "3": mostrarTrabajador();   break;
                case "4": mostrarTabla();        break;
                case "5": exportarDatos();       break;
                case "6": generarTrabajadores(); break;
                case "7": eliminarTrabajador();  break;
                case "s": salir = true;          break;
                default: System.err.println("ALERTA POR SUBNORMAL"); break;
            }
        }while(!salir);
    }

    private void annadirTrabajador() {
        String[]data = new String[4];
        System.out.print("Introduzca dni: ");
        data[0] = sc.nextLine();
        System.out.println("Introduzca nombre: ");
        data[1] = sc.nextLine();
        System.out.println("Introduzca apellidos: ");
        data[2] = sc.nextLine();
        System.out.println("Introduzca salario: ");
        data[3] = sc.nextLine();
        try{
            c.addTrabajador(data);
        }catch(ParseException e){
            System.out.println("ERROR: Datos incorrectos; la informacion no pudo ser guardada");
        }
    }

    private void editarTrabajador() {
        boolean salir=false;
        String dniAntiguo = localizarTrabajador();
        if(null == dniAntiguo) return;
        String[]data = c.getTrabajador(Integer.parseInt(dniAntiguo));
        
        do{
            imprimirTrabajador(data);
            System.out.println("EDITAR:"
                    + "\n\t1)dni"
                    + "\n\t2)nombre"
                    + "\n\t3)apellidos"
                    + "\n\t4)salario"
                    + "\n\ts)salir");
            String respuesta = sc.nextLine();
            switch(respuesta){
                case "1": System.out.print("Nuevo dni: "); data[0] = sc.nextLine(); 
                           if(c.existeTrabajador(Integer.parseInt(data[0]))){
                               System.err.println("ERROR: dni ya registrado");
                               data[0] = dniAntiguo;
                           }
                    break;
                case "2": System.out.print("Nuevo nombre: "); data[2] = sc.nextLine();     break;
                case "3": System.out.print("Nuevos apellidos: "); data[1] = sc.nextLine(); break;
                case "4": System.out.print("Nuevo salario: "); data[3] = sc.nextLine();    break;
                case "s": salir = true; break;
            }
        }while(!salir);
        
        try{
            c.editTrabajador(Integer.parseInt(dniAntiguo),data);
        }catch(ParseException e){
            System.err.println("ERROR: Datos incorrectos; la informacion no pudo ser guardada");
        }
    }

    private void mostrarTrabajador() {
        String dni = localizarTrabajador();
        if(null == dni) return;
        imprimirTrabajador(c.getTrabajador(Integer.parseInt(dni)));
    }

    private void mostrarTabla() {
        System.out.print("¿En que orden desea los trabajadores ordenados?"
                +"\n\t1)Antiguedad"
                +"\n\t2)Salario"
                +"\n\t3)Apellidos y nombre");
        String respuesta = sc.nextLine();
        switch(respuesta){
            case "1": c.sortData(antiguedad); break;
            case "2": c.sortData(salario); break;
            case "3": c.sortData(apellidosNombre); break;
            default: System.err.println("ERROR: ALERTA POR SUBNORMAL\nLos datos saldran sin ordenar porque no sabes pulsar una puta tecla entre las 3 que tienes a elegir; pedazo de basura humana");
        }
        
        List<String>lista = c.getAllFormattedData();
        String separador = String.format("+%10s+%15s+%10s+%10s+%20s+"," "," "," "," "," ").replace(" ","-");
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(separador).append("\n").append(String.format("|%s|","TITULO")).append("\n").append(separador);
        for(String s : lista)
           sb.append("\n").append(s).append("\n").append(separador);
        sb.append("\n");
        
        System.out.println(sb.toString());
    }

    private void exportarDatos() {
        try{
            c.exportData();
        }catch(IOException e){
            System.err.println("ERROR: Data couldn't be exported.");
        }
    }

    private void generarTrabajadores() {
        c.generateRandomTrabajadores(Constantes.NUM_TRABAJADORES);
    }

    private void eliminarTrabajador() {
        String dni,respuesta;
        
        dni = localizarTrabajador();
        if(null == dni) return;
        
        String[]data = c.getTrabajador(Integer.parseInt(dni));
        imprimirTrabajador(data);
        
        System.out.println("¿Desea elimintar realmente a este trabajador? (S/N)");
        do{ respuesta=sc.nextLine(); }while(!"sSnN".contains(respuesta));
        if(respuesta.equalsIgnoreCase("s"))
            c.deleteTrabajador(Integer.parseInt(dni));
        
    }

    private void imprimirTrabajador(String[]data) {
        System.out.println("\tDNI:       " + data[0]);
        System.out.println("\tApellidos: " + data[1]);
        System.out.println("\tNombre:    " + data[2]);
        System.out.println("\tSalario:   " + data[3]);
    }
    
    private String localizarTrabajador(){
        boolean incorrecto = false;
        String dni, respuesta;
        do{ 
            System.out.print("Introduzca dni: ");
            dni = sc.nextLine();
            try{
                Integer.parseInt(dni);  
            }catch(NumberFormatException e){
                System.err.println("ERROR: introduzca un dni en formato valido");
                incorrecto = true;
            }
            if(incorrecto || !c.existeTrabajador(Integer.parseInt(dni))){
                incorrecto = false;
                System.err.println("ERROR: trabajador no encontrado\n¿Abortar? (S/N)");
                do{
                    respuesta=sc.nextLine();
                }while(!"sSnN".contains(respuesta));
                if(respuesta.equalsIgnoreCase("s")) return null;
            }
        }while(!c.existeTrabajador(Integer.parseInt(dni)));
        
        return dni;
    }
}
