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
   private List<Alumno> alumnos;
   
    public void generateRandomListOfAlumnos(){
        Alumno a = null;
        
        if(null == this.alumnos)
            this.alumnos = new ArrayList<>();
        else if (!this.alumnos.isEmpty())
            this.alumnos.clear();
        
        for(int i=0 ; i<Constantes.NUM_ALUMNOS; i++){
            a = new Alumno();
            Alumno.factoryMethod(a);
            alumnos.add(a);
        }
    }
    
    public List<String> generateHtmlCode(){
        List<String> lista = new ArrayList();
        
        lista.add("<!DOCTYPE html><HTML><HEAD><meta charset=\"UTF_8\">\n");
        lista.add("<HEAD><H1>Datos de alumnos</H1></HEAD>");
        lista.add("<BODY>");
        lista.add("<TABLE BORDER = 1>");
        lista.add("<TR>  <TD><STRONG>Nombre y apellidos</TRONG></td> <TD><STRONG>DNI</TRONG></td> <TD><STRONG>Asistencia</STRONG></TD> </TR>\n");
        
        if( null == this.alumnos || this.alumnos.isEmpty())
            lista.add("<TR>  <TD><STRONG>No data aviable</STRONG></TD> </TR>\n");
        else{
            for(Alumno a : this.alumnos )
                lista.add(a.toHtmlString());
        }
        
        lista.add("</TABLE></BODY></HTML>");
        
        return lista;
    }
    public List<String>generateTabbedCode(){
        List<String> lista = new ArrayList();
        
        for(Alumno a : this.alumnos)
            lista.add(a.toTabbedString());
        
        return lista;
    }
    public String generateDataTable(){
        return generateTable(this.alumnos,"ALUMNOS");
    }
    public String generateAssistanceDatatable(float tasaMinima){
        List <Alumno> pocaAsistencia = new ArrayList<>();
        
        for(Alumno a : this.alumnos)
            if(Alumno.calculateTasaAsistencia(a) <= tasaMinima)
                pocaAsistencia.add(a);
          
        return generateTable(pocaAsistencia,String.format("ALUMNOS CON ASISTENCIA INFERIOR AL %5.2f%%",tasaMinima*100));
    }
        private String generateTable(List<Alumno> alumnos, String titulo){
        StringBuilder sb = new StringBuilder();
        
        sb.append(titulo);
        sb.append(String.format("\n|%33s|%9s|%30s|","Nombre y Apellidos", "DNI", "Asistencia"));
        
        if(alumnos.isEmpty())
            sb.append("No se tienen registros");
        else{
            for(Alumno a : alumnos)
                sb.append(a.toString());
            
            sb.append("\n\nTotal.............." + alumnos.size());
        }
        
        return sb.toString();
    }
    

   
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
