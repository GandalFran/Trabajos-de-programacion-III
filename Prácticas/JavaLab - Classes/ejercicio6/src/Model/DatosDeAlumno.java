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
        this.personales = new DatosPersonales();
        this.direccion = new DatosDireccion();
    }
  
    public static void factoryMethod(DatosDeAlumno datos){
        DatosPersonales.factoryMethod(datos.personales);
        DatosDireccion.factoryMethod(datos.direccion);
    }

    @Override
    public String toString() {
        return this.personales.toString() + this.direccion.toString().substring(2);   //El substring es para quitar el \n| de comienzo del segundo
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
