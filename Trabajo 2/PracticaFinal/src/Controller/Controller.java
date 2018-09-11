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


package Controller;

import Data.SuperMercado;
import Otros.Constantes;
import Otros.TipoSortCliente;
import Otros.TipoSortProducto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador.
 * @author franp
 */
public class Controller {
    
    private final SuperMercado s = new SuperMercado();
    private final FileHandler fh = new FileHandler();
    
    
    //ARRANQUE
    /**
     * Realiza la carga de los productos y los clientes de los archivos pertinentes
     * @throws java.io.IOException Si no consigue leer alguno de los ficheros o no encuentra ninguno
     */
    public void arranque() throws IOException{
        List<String>clientesLeidos;
        List<String>productosLeidos;
        String [][] productos;
        String [][] clientes;
        
        if(fh.exists(Constantes.RUTA_CLIENTES_BIN)){
            System.err.println("DATOS CARGADOS DE: de clientes.bin");
            s.setClientes(fh.loadBinaryFileCliente(Constantes.RUTA_CLIENTES_BIN));
        }else{
            System.err.println("DATOS CARGADOS DE: de clientes.csv");
            clientesLeidos = fh.importFromTextFile(Constantes.RUTA_CLIENTES_CSV);
            clientes = fh.parseCsv(clientesLeidos,"#");
            
            s.guardarClientes(clientes);
        }
        
        if(fh.exists(Constantes.RUTA_PRODUCTOS_BIN)){
            System.err.println("DATOS CARGADOS DE: de productos.bin");
            s.setProductos(fh.loadBinaryFileProducto(Constantes.RUTA_PRODUCTOS_BIN));
        }else{
            System.err.println("DATOS CARGADOS DE: de productos.csv");
            productosLeidos = fh.importFromTextFile(Constantes.RUTA_PRODUCTOS_CSV);
            productos = fh.parseCsv(productosLeidos,"#");
            s.guardarProductos(productos);
        }
    }
   
//======================================================================================================================//
    //SALIDA DEL PROGRAMA
    /**
     * Guarda los datos de clientes en clientes.bin y los datos de los prodcutos en productos.bin
     * @throws java.io.IOException Si no se consigue escribir alguno de los archivos.
     */
    public void salidaPrograma() throws IOException{
        fh.writeBinaryFileCliente(Constantes.RUTA_CLIENTES_BIN,s.getClientes());
        fh.writeBinaryFileProducto(Constantes.RUTA_PRODUCTOS_BIN,s.getProductos());
    }
    
//======================================================================================================================//
     //ARCHIVOS
    /**
     * Exporta los datos de los productos actuales a un fichero encolumnado
     * @throws java.io.IOException Si no consigue exportar a fichero.
     * @see FileHandler#exportToTextFile(java.lang.String, java.util.List)
     * @see Data.SuperMercado#getInfoProductosEncolumnado()
     */
    public void exportarProductosEncolumnado() throws IOException{
        List<String>productos = s.getInfoProductosEncolumnado();
        
        if( null == productos){
            productos = new ArrayList<>();
            productos.add("No data aviable");
        }
            
        fh.exportToTextFile(Constantes.RUTA_PRODUCTOS_COL, productos);
    }
    /**
     * Exporta los datos de los productos actuales a un fichero html
     * @throws java.io.IOException Si no consigue exportar a fichero.
     * @see FileHandler#exportToTextFile(java.lang.String, java.util.List)
     * @see Data.SuperMercado#getInfoProductosHtml()
     */
    public void exportarProductosHtml() throws IOException{
        List<String>productos = s.getInfoProductosHtml();
        if( null == productos){
            productos = new ArrayList<>();
            productos.add("<TR><TD><STRONG>No data aviable</STRONG></TD></TR>");
        }
        productos.add(0,String.format("<TR> <TD><STRONG>%s</STRONG></TD> <TD><STRONG>%s</STRONG></TD> <TD><STRONG>%s</STRONG></TD> <TD><STRONG>%s</STRONG></TD></TR>","Nombre","Precio","Iva","Stock"));
       
        fh.generarEnvoltorioHtml(productos,"PRODUCTOS");
        fh.exportToTextFile(Constantes.RUTA_PRODUCTOS_HTML,productos);
    }
 
//======================================================================================================================//
    //CLIENTES
    /**
     * Añade cliente a la lista de clientes del modelo.
     * @param data datos del cliente en el fomato indicado en la clase Cliente.
     * @see Data.Cliente#toStringArray()
     */
    public void annadirCliente(String[]data) throws NumberFormatException{
        s.saveCliente(data);
    }
    /**
     * Cambia el estado del un cliente
     * @param idCliente id del cliente a cambiar
     * @return 0 si tiene exito y -1 si fracasa
     * @see modificarCliente
     */
    public int cambiarEstadoCliente(String idCliente) {
       String[]nuevaInfo = s.getCliente(idCliente);
       if(null == nuevaInfo) return -1;
       nuevaInfo[4] = (nuevaInfo[4].equals("activo"))? ("inactivo") : ("activo");
       return modificarCliente(nuevaInfo);
    }
    /**
     * Modifica la informacion de un cliente
     * @param nuevaInfo informacion modificada de un cliente
     * @return 0 si tiene exito y -1 si no encuentra al cliente
     */
    public int modificarCliente(String[]nuevaInfo){
        return s.modificarCliente(nuevaInfo);
    }
    /**
     * Modifica la informacion de un cliente; teniendo en cuenta que puede haber cambiado su dni.
     * @param nuevaInfo informacion modificada de un cliente
     * @param idAntiguo dni antiguo del cliente (Que es como esta registrado en la base de datos).
     * @return 0 si tiene exito y -1 si no encuentra al cliente
     */
    public int modificarCliente(String[]nuevaInfo,String idAntiguo){
        return s.modificarCliente(nuevaInfo,idAntiguo);
    }
    /**
     * Dice si un cliente esta activado
     * @param idCliente dni del cliente a ver si esta activado
     * @return true si esta activado y false en caso contrario. Si no encuentra al cliente devuelve tambien false.
     */
    public boolean estaActivado(String idCliente) {
        String[]infoCliente = s.getCliente(idCliente);
        if(null == infoCliente) return false;
        return (infoCliente[4].equalsIgnoreCase("activo"));
    }

//======================================================================================================================//
    //RESULTADOS - TERMINADO - POR PROBAR
    /**
     * Obtiene el importe total de las ventas (facturas y tickets) de una ejecucion 
     * @return importe total de las ventas acumuladas 
     */
    public float getImporteTotalVentas(){ 
        float total;
        String[][]ticketData = s.getAllTicketData();
        total = (null == ticketData) ?  (0) : (calcularTotal(ticketData,1));
        
        String[][]clientes = s.getAllClientData();
        if(null == clientes) return -1;
        for(String[]c : clientes) 
            total += getImporteTotalCliente(c[0]);

        return total;
    }
    
    /**
     * Obtiene la cantidad que un cliente ha gastado en la tienda
     * @param idCliente cliente del cual se va a obtener el importe total de las ventas
     * @return importe total de lo gastado por el cliente en el establecimiento
     */
    public float getImporteTotalCliente(String idCliente){
        String[][]facturas = s.getFacturasCliente(idCliente);
        return (null == facturas) ?  (0) : (calcularTotal(facturas,1));
    }
    
    /**
     * Obtiene el valor total de los productos que quedan en el almacen
     * @return importe total de el valor de los productos de el almacen
     */
    public float getvalorExistenciasAlmacen(){
        String[][]productData = s.getAllProductData();
        return (null == productData) ?  (0) : (calcularTotal(productData,1,3));
    }

    /**
     * Calcula el total del la suma de los importes de unos tickets/facturas
     * @param data Informacion de los tickets/facturas a calcular la suma de cantidades y precios. Cada fila es la informacion un producto.
     * @param pos posicion del importe del ticket/factura
     * @return el importe total si tiene exito y -1 si falla porque algun dato no esta permitido
     */
    private float calcularTotal(String[][]data,int pos){
        float importeTotal = 0;
        
        for(String[]f : data) 
            importeTotal += Float.parseFloat(f[pos]);
        
        return importeTotal;
    }
    /**
     * Calcula el total del precio (sin iva) de los productos que se le dan en data
     * @param data Informacion de los productos a calcular la suma de cantidades y precios. Cada fila es la informacion un producto
     * @param pos posicion del precio del producto
     * @param posMultiplo posicion de la cantidad del producto
     * @return el importe total si tiene exito y -1 si falla porque algun dato no esta permitido
     */
    private float calcularTotal(String[][]data,int pos, int posMultiplo){
        float importeTotal = 0;
        
        for(String[]f : data) 
            importeTotal += Float.parseFloat(f[pos]) * Integer.parseInt(f[posMultiplo]);
        
        return importeTotal;
    }
 //======================================================================================================================//
    //LISTADOS - TERMINADO - POR PROBAR

    /**
     * Ordena los clientes
     * @param sort criterio de ordenacion
     */
    public void sortClientes(TipoSortCliente sort){
        s.sortClientes(sort);
    }
    /**
     * Ordena los productos
     * @param sort criterio de ordenacion
     */
    public void sortProductos(TipoSortProducto sort){
        s.sortProductos(sort);
    }
        
//======================================================================================================================//
    //VENTAS

    /**
     * Disminuye el stock de un producto en una determinada cnatidad
     * @param idProducto id del producto a reducir el stock
     * @param cantidadProducto cantidad a reducir
     */
    public void disminuirStock(String idProducto, int cantidadProducto) {
        String[]nuevaInfo = s.getProducto(idProducto);
        if(null == nuevaInfo) return;
        nuevaInfo[3] = String.valueOf(Integer.parseInt(nuevaInfo[3]) - cantidadProducto);
        s.modificarProducto(nuevaInfo);
    }
    
    /**
     * Guarda la informacion sobre un ticket en el modelo
     * @param productos lista de productos que contiene el ticket
     * @param cantidad cantidades en las que esta presente cada producto en productos
     * @return id del ticket si tiene exito y null si fracasa
     */
    public String saveTicket(List<String> productos, List<Integer> cantidad){
        float total = 0;
        String[] producto;
        
        for(int i=0; i<productos.size(); i++){
            producto = s.getProducto(productos.get(i));
            total += Float.parseFloat(producto[1]) * (1 + Float.parseFloat(producto[2])) * cantidad.get(i);
        }

        String idTicket = s.saveTicket(total);
        return idTicket;
    }
    /**
     * Guarda la informacion sobre una factura en el modelo
     * @param idCliente id del cliente al que pertenece la factura
     * @param productos lista de productos que contiene la factura
     * @param cantidad cantidades en las que esta presente cada producto en productos
     * @return id de la factura si tiene exito y null si fracasa
     */
    public String saveFactura(String idCliente, List<String> productos, List<Integer> cantidad){
        float total = 0;
        String[] producto;
        
        int i = 0;
        for(String idProducto : productos){
            producto = s.getProducto(idProducto);
            total += Float.parseFloat(producto[1]) * (1 + Float.parseFloat(producto[2])) * cantidad.get(i++);
        }
        String idFactura = s.saveFactura(idCliente,total);
        return idFactura;
    }


//======================================================================================================================//
    //OTROS AUXILIARES

    /**
     * Nos dice si tenemos el dni de un cliente en el programa
     * @param idCliente id del cliente a buscar
     * @return devuelve true si existe y false si no existe
     */
    public boolean existeCliente(String idCliente){
        return (null != s.getCliente(idCliente));
    }
    /**
     * Nos dice si tenemos este producto registrado
     * @param idProducto id del producto a buscar
     * @return devuelve true si existe y false si no existe
     */
    public boolean existeProducto(String idProducto){
        String[]p = s.getProducto(idProducto);
        return (null == p) ? (false):(true);
    }
    
    
    /**
     * Devuleve los datos de un Cliente
     * @param idCliente id del cliente del que se quieren los datos
     * @return String[] con los datos de un cliente
     */
    public String[] getInfoCliente(String idCliente) {
        return s.getCliente(idCliente);
    }
    /**
     * Devuleve los datos de un Producto
     * @param idProducto id del producto del que se quieren los datos
     * @return String[] con los datos de un producto
     */
    public String[] getInfoProducto(String idProducto){
        return s.getProducto(idProducto);
    }
    /**
     * Devuleve los datos de un Ticket
     * @param idTicket id del ticket del que se quieren los datos
     * @return String[] con los datos de un ticket
     */
    public String[] getInfoTicket(String idTicket) {
        return s.getTicket(idTicket);
    }
    /**
     * Devuleve los datos de una Factura
     * @param idCliente id del cliente al cual pertenece la factura
     * @param idFactura id del producto del que se quieren los datos
     * @return String[] con los datos de una factura
     */
    public String[] getInfoFactura(String idCliente, String idFactura) {
       return s.getFactura(idCliente,idFactura);
    }

    
    /**
     * Devuelve informacion sobre todos los productos registrados
     * @return cada fila es un productos y las columnas toman los siguientes valores: f[0] nombre, f[1] precio, f[2] iva y f[3] stock
     */
    public String[][] getAllProductos(){
        return s.getAllProductData();
    }
    /**
     * Devuelve informacion sobre los todos clientes registrados
     * @return cada fila es un cliente y las columnas toman los siguientes valores: f[0] dni, f[1] nombre, f[2] apellidos, f[3] direccion y f[4] estado
     */
    public String[][] getAllClientes(){
       return s.getAllClientData();
    }

}
