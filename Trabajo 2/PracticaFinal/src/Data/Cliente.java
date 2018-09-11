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
import Otros.EstadosCliente;
import static Otros.EstadosCliente.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *Informacion sobre un cliente: dni, nombre, apellidos, direccion, estado y facturas.
 * @author franp
 */
public class Cliente implements Serializable{
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private EstadosCliente estado;
    private List<Factura> facturas;
   
    
    public Cliente(String dni, String nombre, String apellidos, String direccion, EstadosCliente estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.estado = estado;
        this.facturas = new ArrayList<>();
    }
    public Cliente(String idCliente){
        this.dni = idCliente;
        this.nombre = "UNKNOWN";
        this.apellidos = "UNKNOWN";
        this.direccion = "UNKNOWN";
        this.estado = INACTIVO;
        this.facturas = new ArrayList<>();
    }

    
    /**
     * Rellena un cliente con los datos contenidos en data
     * @param data datos de un cliente en el formato definido en Data.Cliente.toStringArray
     * @see Data.Cliente toStringArray
     * @return Cliente con los datos de data
     */
    public static Cliente fillCliente(String[]data){
        Cliente c = new Cliente(data[0]);
        c.nombre = data[1];
        c.apellidos = data[2];
        c.direccion = data[3];
        c.estado = (data[4].equals("activo")) ? (ACTIVO) : (INACTIVO);
            
        return c;
    }
    
    /**
     * Devuelve informacion sobre un cliente
     * @return String[] con la siguiente informacion f[0] dni, f[1] nombre, f[2] apellidos, f[3] direccion y f[4] estado
     */
    public String[]toStringArray(){
        String[]data = new String[5];
        data[0] = this.dni;
        data[1] = this.nombre;
        data[2] = this.apellidos;
        data[3] = this.direccion;
        data[4] = (this.estado == ACTIVO)? ("activo") : ("inactivo");
        return data;
    }
    
    /**
     * Devuelve los datos de todas las facturas;
     * @return null si no hay facturas o una matriz donde cada fila es una factura.
     * @see Data.Factura toStringArray
     */
    public String[][]getAllFacturasCliente(){
        if(null == this.facturas || this.facturas.isEmpty()) return null;
        String[][]fact = new String[this.facturas.size()][0];
        
        int i = 0;
        for(Factura f : this.facturas)
            fact[i++] = f.toStringArray();
        
        return fact;
    }
    

    void addFactura(Factura f) {
        if(null == this.facturas) facturas = new ArrayList<>();
        this.facturas.add(f);
    }
    
    
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public EstadosCliente getEstado() {
        return estado;
    }
    public void setEstado(EstadosCliente estado) {
        this.estado = estado;
    }
    public List<Factura> getFacturas() {
        return facturas;
    }
    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
