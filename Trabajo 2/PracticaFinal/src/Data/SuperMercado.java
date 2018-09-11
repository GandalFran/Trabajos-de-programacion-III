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

package Data;

import Data.Comparadores.*;
import Otros.Constantes;
import static Otros.EstadosCliente.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Otros.TipoSortCliente;
import static Otros.TipoSortCliente.*;
import Otros.TipoSortProducto;
import static Otros.TipoSortProducto.*;

/**
 * Modelo.
 * @author franp
 */
public class SuperMercado {
    private List<Cliente> clientes;
    private List<Ticket> tickets;
    private List<Producto> productos;

    
    
    public SuperMercado(List<Cliente> clientes, List<Ticket> tickets, List<Producto> productos) {
        this.clientes = clientes;
        this.tickets = tickets;
        this.productos = productos;
    }
    public SuperMercado() {
        this.clientes = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.productos = new ArrayList<>();
    }


    /**
     * Devuelve datos de un producto.
     * @param idProducto id del producto del que se busca obtener datos.
     * @return null si no se encuentra o los datos de un producto.
     * @see Data.Producto#toStringArray()
     */
    public String[] getProducto(String idProducto){
        Producto p = searchProducto(idProducto);
        return (null == p)? (null) : (p.toStringArray());
    }
    /**
     * Devuelve datos de un cliente.
     * @param idCliente id del cliente del que se busca obtener datos.
     * @return null si no se encuentra o los datos de un cliente.
     * @see Data.Cliente#toStringArray() 
     */
    public String[] getCliente(String idCliente){
        Cliente c = searchCliente(idCliente);
        return (null == c)? (null) : (c.toStringArray());
    }
    /**
     * Devuelve datos de un ticket.
     * @param idTicket id del producto del que se busca obtener datos.
     * @return null si no se encuentra o los datos de un ticket.
     * @see Data.Ticket#toStringArray() 
     */
    public String[] getTicket(String idTicket) {
        Ticket t = searchTicket(idTicket);
        return (null == t)? (null) : (t.toStringArray());
    }
    /**
     * Devuelve datos de una factura.
     * @param idCliente id del cliente al cual pertenece la factura.
     * @param idFactura id de la factura de la que se busca obtener datos.
     * @return null si no se encuentra o los datos de una factura.
     * @see Data.Factura#toStringArray() 
     */
    public String[] getFactura(String idCliente, String idFactura) {
        Factura f = searchFactura(idCliente,idFactura);
        return (null == f)? (null) : (f.toStringArray());
    }
    
    
    /**
     * Devuelve los datos de todos los productos.
     * @return null si no hay productos o una matriz donde cada fila es un producto.
     * @see Data.SuperMercado#getProducto(java.lang.String) 
     * @see Data.Producto#toStringArray() 
     */
    public String[][] getAllProductData() {
       if(null == this.productos || this.productos.isEmpty()) return null;
       String[][]data = new String[this.productos.size()][0];
       
       int i = 0;
       for(Producto p : this.productos)
           data[i++] = p.toStringArray();
       
       return data;
    }
    /**
     * Devuelve los datos de todos los clientes.
     * @return null si no hay productos o una matriz donde cada fila es un cliente.
     * @see Data.SuperMercado#getCliente(java.lang.String) 
     * @see Data.Cliente#toStringArray() 
     */
    public String[][] getAllClientData() {
       if(null == this.clientes || this.clientes.isEmpty()) return null;
       String[][]data = new String[this.clientes.size()][0];

       int i = 0;
       for(Cliente c : this.clientes)
          data[i++] = c.toStringArray();
      
       return data;
    }
    /**
     * Devuelve los datos de todos los tickets.
     * @return null si no hay productos o una matriz donde cada fila es un ticket.
     * @see Data.SuperMercado#getTicket(java.lang.String) 
     * @see Data.Ticket#toStringArray() 
     */
    public String[][] getAllTicketData() {
        if(null == this.tickets || this.tickets.isEmpty()) return null;
        String[][]data = new String[this.tickets.size()][0];
       
        int i = 0;
        for(Ticket t : this.tickets)
            data[i++] = t.toStringArray();

        return data;
    }
    /**
     * Devuelve los datos de todas las facturas de un cliente.
     * @param idCliente dni del cliente del cual se quieren obtener las facturas.
     * @return null sin no encuentra al cliente o si no hay facturas; o una matriz donde cada fila es una factura.
     * @see Data.SuperMercado#getFactura
     * @see Data.Factura#toStringArray() 
     */
    public String[][] getFacturasCliente(String idCliente){
        Cliente c = searchCliente(idCliente);
        if( null == c ) return null;
        
        return c.getAllFacturasCliente();
    }
    
    
    
    /**
     * Devuelve los datos de todos los productos en formato encolumnado.
     * @return null si no hay productos o una lista con la informacion de todos los productos encolumnada.
     */
    public List<String> getInfoProductosEncolumnado() {
        if(null == this.productos || this.productos.isEmpty())
            return null;
        
        List<String>productosEncolumnados = new ArrayList<>();
        for(Producto p : this.productos)
            productosEncolumnados.add(p.toFormatedString());
        
        return productosEncolumnados;
    }
    /**
     * Devuelve los datos de todos los productos en formato html.
     * @return null si no hay productos o una lista con la informacion de todos los productos en formato html.
     */
    public List<String> getInfoProductosHtml(){
        if(null == this.productos || this.productos.isEmpty())
            return null;
        
        List<String>productosEncolumnados = new ArrayList<>();
        for(Producto p : this.productos)
            productosEncolumnados.add(p.toHtmlString());
        
        return productosEncolumnados;
    }
    
    

    
    /**
     * Ordena los productos.
     * @param sort criterio de ordenacion.
     * @see Otros.TipoSortProducto
     */
    public void sortProductos(TipoSortProducto sort) {
       Comparator<Producto>c = null;
        switch(sort){
            case IVA_PRECIO:
                c = new ComparadorPorIvayPrecio();
            break;
            case ALFABETICO:
                c = new ComparadorPorNombreProducto();
            break;
        }
        Collections.sort(this.productos,c);
    }
    /**
     * Ordena los clientes.
     * @param sort criterio de ordenacion.
     * @see Otros.TipoSortCliente
     */
    public void sortClientes(TipoSortCliente sort) {
        Comparator<Cliente>c = null;
        switch(sort){
            case APELLIDOS_NOMBRE:
                c = new ComparadorPorApellidosyNombre();
            break;
            case DNI:
                c = new ComparadorPorDni();
            break;
        }
        Collections.sort(this.clientes,c);
    }

    
    
    
    /**
     * Guarda un cliente.
     * @param data informacion del cliente en el formato definiddo en Cliente.fillCliente();
     * @see Cliente#fillCliente(java.lang.String[]) 
     */
    public void saveCliente(String[] data) {
        if(null == this.clientes ) this.clientes = new ArrayList<>();
        this.clientes.add(Cliente.fillCliente(data));
        //Ordenamos para poder hacer busquedas
        sortClientes(DNI);
    }
    /**
     * Guarda la informacion de un conjunto de productos.
     * Si no se comprueba que los datos son correctos antes de pasarselos; puede dar errores a la hora de trabajar con estos.
     * @param arrayProductos array con toda la informacion de los productos.
     */
    public void guardarProductos(String[][] arrayProductos) throws NumberFormatException{
        if(null == this.productos || !this.productos.isEmpty())
            this.productos = new ArrayList<>();
        
        for(String[]f : arrayProductos)
            this.productos.add(Producto.fillProducto(f));
        //Ordenamos para poder hacer busquedas
        sortProductos(ALFABETICO);
    }
    /**
     * Guarda la informacion de un conjunto de clientes.
     * Si no se comprueba que los datos son correctos antes de pasarselos; puede dar errores a la hora de trabajar con estos.
     * @param arrayClientes array con toda la informacion de los clientes.
     */
    public void guardarClientes(String[][] arrayClientes) {
        if(null == this.clientes || !this.clientes.isEmpty())
            this.clientes = new ArrayList<>();
        
        for(String[]f : arrayClientes)
            this.clientes.add(Cliente.fillCliente(f));
        //Ordenamos para poder hacer busquedas
        sortClientes(DNI);
    }
    /**
     * Guarda un ticket.
     * @param total importe del ticket.
     * @return id del ticket.
     */
    public String saveTicket(float total){
        Ticket t = new Ticket(total);
        if(null == this.tickets) this.tickets = new ArrayList<>();
        this.tickets.add(t);
        //Ordenamos para poder encontrar los tickets en futuras busquedas
        Collections.sort(this.tickets, new ComparadorPorId());
        return t.getId();
    }
   /**
     * Guarda la una factura asociada a un cliente.
     * @param idCliente cliente al que asociar la factura.
     * @param total importe de la factura.
     * @return null si el cliente no existe o esta inactivo; o el id de la factura en caso contrario.
     */
    public String saveFactura(String idCliente, float total) {
        Factura f = new Factura(idCliente,total);
        Cliente c = searchCliente(idCliente);
        if(null == c || c.getEstado()== INACTIVO )
            return null;
        else
            c.addFactura(f);
        //Ordenamos para poder encontrar las facturas en futuras busquedas
        Collections.sort(c.getFacturas(), new ComparadorPorId());
        
        return String.valueOf(f.getId());
    }
    

    /**
     * Busca un producto en la lista de productos.
     * @param idProducto id del producto a buscar.
     * @return null si la lisa de productos esta vacia o no se encuentra el producto; o en otro caso el producto.
     */
    private Producto searchProducto(String idProducto){
        if(null == this.productos || this.productos.isEmpty()) return null;
        
        Producto p = new Producto(idProducto);
        int index = Collections.binarySearch(this.productos,p,new ComparadorPorNombreProducto());
        return (index>=0)?  (this.productos.get(index)) : (null);
    }
    /**
     * Busca un cliente en la lista de clientes.
     * @param idCliente id del cliente a buscar.
     * @return null si la lisa de clientes esta vacia o no se encuentra en cliente; o en otro caso el cliente.
     */
    private Cliente searchCliente(String idCliente){
        if(null == this.clientes || this.clientes.isEmpty()) return null;

        Cliente c = new Cliente(idCliente); 
        int index = Collections.binarySearch(this.clientes,c,new ComparadorPorDni());
        return (index>=0) ?  (this.clientes.get(index)) : (null);
    }
    /**
     * Busca un ticket en la lista de tickets.
     * @param idTicket id del ticket a buscar.
     * @return null si la lisa de tickets esta vacia o no se encuentra en ticket; o en otro caso el ticket.
     */
    private Ticket searchTicket(String idTicket){
        if(null == this.tickets || this.tickets.isEmpty()) return null;
        Ticket t = new Ticket(idTicket);
        int index = Collections.binarySearch(this.tickets,t,new ComparadorPorId());
        return (index>=0) ?  (this.tickets.get(index)) : (null);
    }
    /**
     * Busca una factura en la lista de facturas de un cliente.
     * @param idCliente id del cliente al cual pertenece la factura.
     * @param idFactura id de la factura a buscar
     * @return null si la lista de clientes esta vacia o no se encuentra el cliente o si la lisa de facturas esta vacia o no se encuentra la factura; o en otro caso la factura.
     */
    private Factura searchFactura(String idCliente, String idFactura){
        Cliente c = searchCliente(idCliente);
        if(null == c || null == c.getFacturas() || c.getFacturas().isEmpty()) return null;
      
        Factura f = new Factura(idFactura);
        int index = Collections.binarySearch(c.getFacturas(),f,new ComparadorPorId());
        return (index>=0) ?  (c.getFacturas().get(index)) : (null);
    }
    

    /**
     * Actualiza la informacion de un producto.
     * El formato debe ser el impuesto en 
     * @see Data.Producto#toStringArray() 
     * @param nuevaInfo informacion a reemplazar del producto.
     * @return -1 si no ecuentra el producto o 0 en el caso de exita.
     */
    public int modificarProducto(String[] nuevaInfo){
        Producto p = searchProducto(nuevaInfo[0]);
        if(null == p) return -1;
        
        p.setPrecio(Float.parseFloat(nuevaInfo[1]));
        p.setIva(Float.parseFloat(nuevaInfo[2]));
        p.setStock(Integer.parseInt(nuevaInfo[3]));
        
        return 0;
    }
    /**
     * Actualiza la informacion de un cliente.
     * El formato debe ser el impuesto en Cliente.toStringArray()
     * @see Data.Cliente#toStringArray() 
     * @param idAntiguo id Antiguo del cliente a modificar
     * @param nuevaInfo informacion a reemplazar del cliente.
     * @return -1 si no ecuentra el producto o 0 en el caso de exita.
     */
    public int modificarCliente(String[]nuevaInfo,String idAntiguo){
        Cliente c = searchCliente(idAntiguo);
        if(null == c) return -1;
        
        c.setDni(nuevaInfo[0]);
        c.setNombre(nuevaInfo[1]);
        c.setApellidos(nuevaInfo[2]);
        c.setDireccion(nuevaInfo[3]);
        c.setEstado((nuevaInfo[4].equals("activo")? (ACTIVO):(INACTIVO)));
        
        //Ordenar cliente para poderlo encontrar luego
        sortClientes(DNI);
        
        return 0;
    }
    /**
     * Actualiza la informacion de un cliente.
     * El formato debe ser el impuesto en 
     * @see Data.Cliente#toStringArray() 
     * @param nuevaInfo informacion a reemplazar del cliente.
     * @return -1 si no ecuentra el producto o 0 en el caso de exita.
     */
    public int modificarCliente(String[]nuevaInfo){
        Cliente c = searchCliente(nuevaInfo[0]);
        if(null == c) return -1;
        
        c.setNombre(nuevaInfo[1]);
        c.setApellidos(nuevaInfo[2]);
        c.setDireccion(nuevaInfo[3]);
        c.setEstado((nuevaInfo[4].equals("activo")? (ACTIVO):(INACTIVO)));
        
        return 0;
    }
    /**
     * Localiza la factura con el ID mas grande y actualiza lastFacturaId en constanes con este.
     * @see Otros.Constantes#lastFacuraId
     */
    private void actualizarNumeroFactura(){
        List<Factura>fac = new ArrayList<>();
        for(Cliente c: this.clientes)
            fac.addAll(c.getFacturas());
        Collections.sort(fac,new ComparadorPorId());
        if(fac.size()>0){
            int i = Integer.parseInt(fac.get(fac.size()-1).getId());
            if(Constantes.lastFacuraId < (i+1)) 
                Constantes.lastFacuraId = 1 + i;  //+1 porque tiene que ese id ya ha sido usado para otra factura
        }
    }
    
    
    
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        //Ordenamos para futuras busquedas
        sortClientes(DNI);
        //Buscamos el identificador de factura mas grande para asegurar que las facturas son nominativas
        actualizarNumeroFactura();
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        //Ordenamos para futuras busquedas
        sortProductos(ALFABETICO);
    }
    public List<Cliente> getClientes() {
        return this.clientes;
    }
    public List<Producto> getProductos() {
        return this.productos;
    }
}
