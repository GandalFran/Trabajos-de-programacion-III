/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franp
 */
public class Model {
   
    private List <DatosDeAlumno> alumnos;


    public void generateAlumnos(int numAlumnos){
        DatosDeAlumno d = null;
        
        if(null == this.alumnos){
            this.alumnos = new ArrayList<>();
        }else if(!this.alumnos.isEmpty()){
            vaciarListaAlumnos();
        }
        
        for(int i=0; i<numAlumnos; i++){
            d = new DatosDeAlumno();
            DatosDeAlumno.factoryMethod(d);
            this.alumnos.add(d);
        }
    }
    
    public void vaciarListaAlumnos(){
        if(null != this.alumnos){
            this.alumnos.clear();
        }
    }
    
    public List<DatosDeAlumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(List<DatosDeAlumno> alumnos) {
        this.alumnos = alumnos;
    }
}
