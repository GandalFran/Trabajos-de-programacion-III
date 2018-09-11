/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author franp
 */
public class DatosDeAlumno {
    
    private DatosPersonales personales;
    private DatosDireccion direccion;

    public DatosDeAlumno(DatosPersonales dp, DatosDireccion dd) {
        this.personales = dp;
        this.direccion = dd;
    }

    public DatosDeAlumno() {
        this.personales = null;
        this.direccion = null;
    }
  
    public static void factoryMethod(DatosDeAlumno datos){
        datos.personales=new DatosPersonales();
        datos.direccion=new DatosDireccion();
        DatosPersonales.factoryMethod(datos.personales);
        DatosDireccion.factoryMethod(datos.direccion);
    }

    @Override
    public String toString() {
        return "DatosDeAlumno{" + "personales=" + personales + ", direccion=" + direccion + '}';
    }
    
    

    public DatosPersonales getPersonales() {
        return personales;
    }
    public void setPersonales(DatosPersonales personales) {
        this.personales = personales;
    }
    public DatosDireccion getDireccion() {
        return direccion;
    }
    public void setDireccion(DatosDireccion direccion) {
        this.direccion = direccion;
    }
}
