/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franp
 */
public class Model {
        
    private List<Persona> personas;

    public String generatePersonasFromTabbed(List<String> lineas) {
        String msg = "\nDatos procesados con exito";
        
        if( null == this.personas){
            this.personas = new ArrayList<>();
        }else if( !this.personas.isEmpty()){
            this.personas.clear();
        }
        
        try{
            Persona p = null;
            for(String s : lineas){
                p = new Persona();
                Persona.factoryMethod(p, s);
                this.personas.add(p);
            }
        }catch( ParseException e){
            this.personas.clear();
            msg = "\nERROR: fichero con formato incorrecto";
        }
        
        return msg;
    }

    public String generateDataTable() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("TABLA DE LA OSTIA");
        sb.append("\n\tNombre\tTelefono\tPeso");
        if( null == this.personas || this.personas.isEmpty() ){
            sb.append("\nNo se tienen datos todavia");
        }else{
            for(Persona p : this.personas)
                sb.append(p.toString());
        }
        
        return sb.toString();
    }
        
        
}
