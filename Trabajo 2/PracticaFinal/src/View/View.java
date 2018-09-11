/*
 * Copyright (C) 2017 franp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package View;

import Controller.Controller;
import Otros.TipoSortCliente;
import static Otros.TipoSortCliente.*;
import Otros.TipoSortProducto;
import static Otros.TipoSortProducto.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


/**
 *Vista.
 * @author franp
 * 
 */
public class View {

    private final Controller c = new Controller();
    private final Scanner sc = new Scanner(System.in);
    private final TableGenerator tg = new TableGenerator();
    
    /**
     *Realiza la carga de los datos, ejecuta el menu principal y guarda los datos
     * @param menus Vector en cuyas posiciones 0,1,2,3,4 y 5 se encuentran respectivamente los menus principal, de archivos, clientes, resultados, listados y ventas
     */
    public void runMenu(String[] menus) {
       boolean salir = false;
       String respuesta = null;
       
       try{
            c.arranque();
       }catch(IOException e){
           System.err.println("ERROR: los datos no pudieron ser importados\nAbortando ejecucion.");
           salir = true;
       }
       
       while(!salir){
           System.out.print(menus[0]);
           do{
               respuesta = sc.nextLine();
           }while(respuesta.isEmpty());
           
           switch(respuesta){
               case "1": menuArchivos(menus[1]);  break;
               case "2": menuClientes(menus[2]);  break;
               case "3": menuReslutados(menus[3]);break;
               case "4": menuListados(menus[4]);  break;
               case "5": menuVentas(menus[5]);    break;
               case "S": case "s": salir = true;  break;
               default: System.err.println("ERROR: Introduzca un caracter valido"); break;
           }
       }
       
       try{
            c.salidaPrograma();
       }catch(IOException e){
           System.err.println("ERROR: los datos no pudieron ser exportados.");
       }
    }

    /**
     * Menu de archivos.
     * @param menu menu a imprimir
     */
    private void menuArchivos(String menu) {
        boolean salir = false;
        String respuesta = null;
       
       do{
           System.out.print(menu);
           do{
               respuesta = sc.nextLine();
           }while(respuesta.isEmpty());
           
           switch(respuesta){
               case "1": exportarProductosEncolumnado(); break;
               case "2": exportarProductosHtml();        break;
               case "V": case "v": salir = true;         break;
               default: System.err.println("ERROR: Introduzca un caracter valido"); break;
            }
        }while(!salir);
    }

    /**
     * Menu de clientes.
     * @param menu menu a imprimir
     */
    private void menuClientes(String menu) {
        boolean salir = false;
        String respuesta = null;
       do{
           System.out.print(menu);
           do{
               respuesta = sc.nextLine();
           }while(respuesta.isEmpty());
           
           switch(respuesta){ 
               case "1": annadirCliente();       break;
               case "2": modificarCliente();     break;
               case "V": case "v": salir = true; break;
               default: System.err.println("ERROR: Introduzca un caracter valido"); break;
           }
       }while(!salir);
    }

    /**
     * Menu de resultados.
     * @param menu menu a imprimir
     */
    private void menuReslutados(String menu) {
        boolean salir = false;
        String respuesta = null;
       
       do{
           System.out.print(menu);
           do{
               respuesta = sc.nextLine();
           }while(respuesta.isEmpty());
           
           switch(respuesta){
               case "1": obtenerImporteTotalVentas();       break;
               case "2": obtenerImporteTotalCliente();      break;
               case "3":  obtenerValorExistenciasAlmacen(); break;
               case "V": case "v":  salir = true; break;
               default: System.err.println("ERROR: Introduzca un caracter valido");  break;
           }
        }while(!salir);
    }

    /**
     * Menu de listados.
     * @param menu menu a imprimir
     */
    private void menuListados(String menu) {
        boolean salir = false;
        String respuesta = null;
       
       do{
           System.out.print(menu);
           do{
               respuesta = sc.nextLine();
           }while(respuesta.isEmpty());
           
           switch(respuesta){
               case "1":  imprimirProductosOrdenados(ALFABETICO);      break;
               case "2": imprimirProductosOrdenados(IVA_PRECIO);       break;
               case "3": imprimirClientesOrdenados(APELLIDOS_NOMBRE);  break;
               case "4": imprimirClientesOrdenados(DNI);               break;
               case "V":  case "v": salir = true;                      break;
               default: System.err.println("ERROR: Introduzca un caracter valido"); break;
           }
       }while(!salir);
    }

    /**
     * Menu de ventas.
     * @param menu menu a imprimir
     */
    private void menuVentas(String menu) {
        boolean salir = false;
        String respuesta = null;
       
       do{
           System.out.print(menu);
           do{
               respuesta = sc.nextLine();
           }while(respuesta.isEmpty());
           
           switch(respuesta){
               case "1": hacerCompraTicket();    break;
               case "2":  hacerCompraFactura();  break;
               case "V": case "v": salir = true; break;
               default: System.err.println("ERROR: Introduzca un caracter valido"); break;
           }
       }while(!salir);
    }

    
    //ARCHIVOS
    /**
     * Exporta todos los datos de los productos a formato encolumnado.
     * @see Controller#exportarProductosEncolumnado() 
     */
    private void exportarProductosEncolumnado(){
        try {
            c.exportarProductosEncolumnado();
        } catch (IOException ex) {
            System.err.println("ERROR: los datos no pudieron ser exportados.");
        }
    }
    /**
     * Exporta todos los datos de los productos a formato html.
     * @see Controller#exportarProductosHtml()
     */
    private void exportarProductosHtml() {
        try {
            c.exportarProductosHtml();
        } catch (IOException ex) {
            System.err.println("ERROR: los datos no pudieron ser exportados.");
        }
    }
    
    
    //CLIENTES
    /**
     * Solicita los datos de un cliente (en el formato de array definido en Cliente) y los añade a la iformacion del modelo.
     * @see Data.Cliente#fillCliente(java.lang.String[]) 
     */
    private void annadirCliente() {
        String idCliente;
        boolean salir;
        do{
            System.out.print("Introduzca DNI de cliente: ");
            idCliente = sc.nextLine();
            if(c.existeCliente(idCliente)){
                System.err.println("Error: el cliente ya esta registrado");
                String respuesta;
                do{
                    System.out.println("¿Desea probar con otro cliente? (s/n)");
                    respuesta = sc.nextLine();
                }while(!"sSnN".contains(respuesta) || respuesta.isEmpty());
                salir = (respuesta.equalsIgnoreCase("s")) ? (false) : (true);
            }else{
                String[]data = new String[5];
                data[0] = idCliente;
                System.out.print("Introduzca nombre: ");
                data[1] = sc.nextLine();
                System.out.print("Introduzca apellidos: ");
                data[2] = sc.nextLine();
                System.out.print("Introduzca direccion: ");
                data[3] = sc.nextLine();
                data[4] = "activo";
                c.annadirCliente(data);
                salir = true;
            }
        }while(!salir);
    }
    /**
     * Modifica los datos de un cliente. Solo se modifican DNI, nombre, apellidos ,direccion y estado.
     * @see Data.Cliente#toStringArray() 
     */
    private void modificarCliente(){
        boolean salir;
        String respuesta;
        String idCliente;
        do{
            System.out.print("Introduzca DNI del cliente a modificar: ");
            idCliente = sc.nextLine();
            if(!c.existeCliente(idCliente)){
                System.err.println("Error: el cliente no existe");
                do{
                    System.out.println("¿Desea probar con otro cliente? (s/n)");
                    respuesta = sc.nextLine();
                }while(!"sSnN".contains(respuesta) || respuesta.isEmpty());
                salir = !respuesta.equalsIgnoreCase("s");
            }else{
                salir = false;
                String[]data = c.getInfoCliente(idCliente);
                do{
                    imprimirCliente(data);
                    System.out.print("\nCAMBIAR: \n\t1)DNI\n\t2)Nombre\n\t3)Apellidos\n\t4)Direccion\n\t5)Estado (activo/inactivo)\n\tv)Volver al menu anterior\nSeleccione: ");
                    respuesta = sc.nextLine();
                    switch(respuesta){
                        case "1":
                            String id;
                            System.out.println("Nuevo DNI: ");
                            do{ id = sc.nextLine(); }while(id.isEmpty());
                                
                            if(c.existeCliente(id) && !data[0].equals(id))
                                System.err.println("ERROR: ese DNI ya esta registrado para otro cliente");
                            else{
                                data[0] = id;
                                c.modificarCliente(data,idCliente);
                            }
                            break;
                        case "2":
                            System.out.print("Nuevo nombre: ");
                            do{ data[1] = sc.nextLine(); }while(data[1].isEmpty());
                            c.modificarCliente(data);
                            break;
                        case "3":
                            System.out.print("Nuevos apellidos: ");
                            do{ data[2] = sc.nextLine(); }while(data[2].isEmpty());
                            c.modificarCliente(data);
                            break;
                        case "4":
                            System.out.print("Nueva direccion: ");
                            do{ data[3] = sc.nextLine(); }while(data[3].isEmpty());
                            c.modificarCliente(data);
                            break;
                        case "5":
                            data[4] = (data[4].equals("activo")) ? ("inactivo") : ("activo");
                            c.cambiarEstadoCliente(idCliente);
                            break;
                        case "v":
                        case "V":
                            salir = true;
                            break;
                        default:
                            System.err.println("Error: introduzca un caracter valido");
                    }
                }while(!salir);
            }
        }while(!salir);
    }
    
    
    //RESULTADOS
    /**
     * Obtiene el importe total de todos los tickets y facturas almacenados en este momento.
     */
    private void obtenerImporteTotalVentas() {
        float f = c.getImporteTotalVentas();
        System.out.println(String.format("Importe total de ventas: %.2f",f));
    }
    /**
     * Obtiene el importe total de todas las facturas almacenados para un cliente.
     */
    private void obtenerImporteTotalCliente() {
        boolean salir = true;
        String idCliente;
        do{
            idCliente = obtenerDniCliente();
            if(null == idCliente){
                System.err.println("ERROR: el cliente que ha introducido no esta registrado.");
                String respuesta;
                do{
                    System.out.println("¿Probar con otro cliente? (s/n)");
                    respuesta = sc.nextLine();
                }while(!"sSnN".contains(respuesta) || respuesta.isEmpty());
                salir = !respuesta.equalsIgnoreCase("s");
            }
        }while(idCliente==null && !salir);
        
        if(null != idCliente){
            String[]data = c.getInfoCliente(idCliente);
            float importe = c.getImporteTotalCliente(idCliente);
            imprimirCliente(data);
            System.out.printf("Importe total del cliente: %.2f",importe);
        }
    }
    /**
     * Obtiene el importe total del valor de todos los products del almacen en este momento.
     */
    private void obtenerValorExistenciasAlmacen() {
        float f = c.getvalorExistenciasAlmacen();
        System.out.println(String.format("Valor total de existencias del almacen: %.2f",f));
    }
    
    
    //LISTADOS
    /**
     * Imprimie los productos ordenados segun el parametro sort.
     * @param sort parametro que indica el tipo de ordenacion de los productos
     * @see Otros.TipoSortProducto
     */
    private void imprimirProductosOrdenados(TipoSortProducto sort){
        c.sortProductos(sort);
        String [][] productos = c.getAllProductos();
        String tabla = tg.generarTablaProductos(productos);
        System.out.println(tabla);
    }
    /** Imprimie los clientes ordenados segun el parametro sort.
     * @param sort parametro que indica el tipo de ordenacion de los productos
     * @see Otros.TipoSortCliente
     */
    private void imprimirClientesOrdenados(TipoSortCliente sort){
        c.sortClientes(sort);
        String[][]clientes = c.getAllClientes();
        String tabla = tg.generarTablaClientes(clientes);
        System.out.println(tabla);
    }
    
    //VENTAS
    /**
     * Realiza una compra con ticket.
     * @see Data.Producto#fillProducto(java.lang.String[]) 
     * @see TableGenerator#generarTicket(java.lang.String[], java.lang.String[][]) 
     */
    private void hacerCompraTicket() {
        List<String>productos = new ArrayList<>();
        List<Integer>cantidad = new ArrayList<>();
      
        //Obtener informacion ticket
        HashMap<String,Integer>mapaProductos = pedirListaProductos();
        productos.addAll(mapaProductos.keySet());
        cantidad.addAll(mapaProductos.values());
        //Operar + mostrar ticket
         if(!productos.isEmpty()){
             String idTicket = c.saveTicket(productos,cantidad);
             
            //Generar ticket
            String[]infoTicket = c.getInfoTicket(idTicket);
            String[][]infoProductos = new String[productos.size()][1];
            int i = 0;
            for(String p : productos){
                infoProductos[i] = c.getInfoProducto(p);
                infoProductos[i][3] = String.valueOf(cantidad.get(i)); 
                i++;
            }
            String ticketData = tg.generarTicket(infoTicket, infoProductos);
            System.out.println(ticketData);
        }
    }
    /**
     * Realiza una compra con factura.
     * @see Controller#saveFactura(java.lang.String, java.util.List, java.util.List) 
     * @see TableGenerator#generarFactura(java.lang.String[], java.lang.String[], java.lang.String[][]) 
     */
    private void hacerCompraFactura() {
        List<String>productos = new ArrayList<>();
        List<Integer>cantidad = new ArrayList<>();
        
        //Obtener dniCliente
        boolean salir = true;
        String idCliente;
        do{
            idCliente = obtenerDniCliente();
            if(null == idCliente){
                System.err.println("ERROR: el cliente que ha introducido no esta registrado.");
                String respuesta;
                do{
                    System.out.println("¿Registrar cliente? (s/n)");
                    respuesta = sc.nextLine();
                }while(!"sSnN".contains(respuesta) || respuesta.isEmpty());
                if(respuesta.equalsIgnoreCase("s")){
                    salir = true;
                    annadirCliente();
                    System.out.println("Cliente registrado\nProcediendo a compra mediante factura");
                    idCliente = obtenerDniCliente();
                }else{
                    idCliente = null;
                    salir = true;
                }
                
            }
        }while(idCliente==null && !salir);
        
        if(null != idCliente){
            if(!c.estaActivado(idCliente)){
                System.err.println("Error: el cliente esta desactivado y no puede realizar compras");
                String respuesta = null;
                do{
                    System.out.println("¿Desea activar cliente? (s/n)");
                    respuesta = sc.nextLine();
                }while(!"sSnN".contains(respuesta) || respuesta.isEmpty());
                if(respuesta.equalsIgnoreCase("s"))
                    c.cambiarEstadoCliente(idCliente);
                else
                    return;
            }
            
            //Obtener informacion ticket
            HashMap<String,Integer>mapaProductos = pedirListaProductos();
            productos.addAll(mapaProductos.keySet());
            cantidad.addAll(mapaProductos.values());
            //Operar + mostrar ticket
            if(!productos.isEmpty()){
                
                String idFactura = c.saveFactura(idCliente,productos,cantidad);
                //Generar ticket
                String[]infoCliente = c.getInfoCliente(idCliente);
                String[]infoFactura = c.getInfoFactura(idCliente,idFactura);
                String[][]infoProductos = new String[productos.size()][1];
                int i = 0;
                for(String p : productos){
                    infoProductos[i] = c.getInfoProducto(p);
                    infoProductos[i][3] = String.valueOf(cantidad.get(i)); 
                    i++;
                }
                String facturaData = tg.generarFactura(infoFactura, infoCliente, infoProductos);
                System.out.println(facturaData);
            }
        }
    }


    
    //AUXILIAR
    /**
     * Pide el DNI de un cliente y comprueba que sea correcto y este activado.
     * @return DNI del cliente
     */
    private String obtenerDniCliente(){
        System.out.print("Introduzca DNI de cliente: ");
        String idCliente = sc.nextLine();
        return (c.existeCliente(idCliente))? (idCliente) : (null);
    }
    
    /**
     * Imprime la informacion de un cliente.
     * @param data datos en el formato definido en Cliente.toStringArray()
     * @see Data.Cliente#toStringArray() 
     */
    private void imprimirCliente(String[]data){
        System.out.println("\nCLIENTE: " + data[0] 
                         + "\n\tApellidos y nombre: " + data[2] + ", " + data[1] 
                         + "\n\tDireccion: " + data[3] 
                         + "\n\tEstado: " + data[4]);
    }
    
    /**
     * Solicita una lista de productos comprobando que sean validos y que haya stock suficiente. Ademas va disminuyendo el stock segun se van consumiendo los productos.
     * @return mapa donde la clave es un id de un producto y el valor es la cantidad de este que ha tomado el cliente.
     */
    private HashMap<String,Integer> pedirListaProductos(){
        HashMap<String,Integer>productos = new HashMap<>();
        String idProducto;
        int cantidadProducto = 0;
        int stockDisponible;
        
        do{
            System.out.print("Introduzca producto:  ");
            idProducto = sc.nextLine().trim();
            if(!idProducto.isEmpty()){
                if(!c.existeProducto(idProducto))
                    System.err.println("ERROR: dicho producto no existe");
                //Obligamos a meter cantidades correctas
                else if(Integer.parseInt(c.getInfoProducto(idProducto)[3]) <= 0)
                    System.err.println("ERROR: no queda stock de dicho producto");
                else{
                    stockDisponible = Integer.parseInt(c.getInfoProducto(idProducto)[3]);
                    do{
                        System.out.println("Stock disponible: " + stockDisponible);
                        System.out.print("Introduzca cantidad a comprar: ");
                        boolean numeroCorrecto;
                        do{
                            numeroCorrecto = true;
                            String temp = sc.nextLine();
                            try{
                                cantidadProducto = Integer.parseInt(temp);
                            }catch(NumberFormatException e){
                                System.err.println("ERROR: introduzca un valor permitido");
                                numeroCorrecto = false;
                            }
                        }while(!numeroCorrecto);
                        
                        if(cantidadProducto<=0)
                            System.err.println("ERROR: introduzca un valor positivo");
                        else if(cantidadProducto > stockDisponible){
                            System.err.println("ERROR: no queda stock suficiente del producto a comprar");
                            String respuesta = null;
                            do{
                                System.out.println("¿Cancelar la compra de este producto? (s/n)");
                                respuesta = sc.nextLine();
                            }while(!"sSnN".contains(respuesta) || respuesta.isEmpty());
                            if(respuesta.equalsIgnoreCase("s"))
                                cantidadProducto=-1;
                        }
                    }while(cantidadProducto>stockDisponible);
                    if(cantidadProducto > 0){
                        if(productos.containsKey(idProducto))
                            productos.replace(idProducto,cantidadProducto + productos.get(idProducto));
                        else 
                            productos.put(idProducto, cantidadProducto);
                        c.disminuirStock(idProducto, cantidadProducto);
                    }
                } 
            }
        }while(!idProducto.isEmpty());
        return productos;
    }
    
    

}
