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
    
    public void generateRandomListOfStudents(int numAlumnos){
        DatosDeAlumno d = null;
        
        List<DatosDeAlumno> listaDeAlumnos = null;
        
        //Limpiamos la lista de alumnos
        if(null == this.alumnos){
            listaDeAlumnos = new ArrayList<>();
        }else if (!this.alumnos.isEmpty()){
            this.alumnos.clear();
        }
        
        //Generamos los datos
        for(int i=0; i<numAlumnos; i++){
            d = new DatosDeAlumno();
            DatosDeAlumno.factoryMethod(d);
            listaDeAlumnos.add(d);
        }
        
        this.alumnos=listaDeAlumnos;
    }
    
    public List<String> generateAdressTable(){
        List<String> lista = new ArrayList();
        DatosDireccion d = null;
        
        //Cabecera HTML
        lista.add("<!DOCTYPE html><HTML><HEAD><meta charset=\"UTF_8\">\n");
        lista.add("<HEAD><H1>Direcciones de alumnos</H1></HEAD>");
        lista.add("<BODY>");
        lista.add("<TABLE BORDER = 1>");
        lista.add("<TR>  <TD><strong>DNI</strong></TD> <TD><strong>Calle</strong></TD> <TD><strong>Numero</strong></TD> <TD><strong>Letra</strong></TD> </TR>\n");
        
        //añadir datos
        if(null == this.alumnos || this.alumnos.isEmpty()){
            lista.add("<TR>  <TD><strong>\t\t\tNo se tienen registros todavia</strong></TD> </TR>");
        }else{
            for(DatosDeAlumno a : this.alumnos){
                d=a.getDireccion();
                lista.add(d.toHTMLString());
            }
        }
        
        //Cerrar cabecera
        lista.add("\n</TABLE></BODY></HTML>");
        
        return lista;
    } 
    public List<String> generatePersonalDataTable(){
        List<String> lista = new ArrayList();
        DatosPersonales p = null;
        
        //Cabecera HTML
        lista.add("<!DOCTYPE html><HTML><HEAD><meta charset=\"UTF_8\">\n");
        lista.add("<HEAD><H1>Datos personales de alumnos</H1></HEAD>");
        lista.add("<BODY>");
        lista.add("<TABLE BORDER = 1>");
        lista.add("<tr>  <td><strong>Nombre y Apellidos</strong></td> <td><strong>edad</strong></td> <td><strong>NIF</strong></td>  </tr>\n");
        
        //añadir datos
        if(null == this.alumnos || this.alumnos.isEmpty()){
            lista.add("<tr>  <td><strong>\t\t\tNo se tienen registros todavia</strong></td> </tr>");
        }else{
            for(DatosDeAlumno a : this.alumnos){
                p=a.getPersonales();
                lista.add(p.toHTMLString());
            }
        }
        
        //Cerrar cabecera
        lista.add("\n</table>");
        
        return lista;
    }
    public String generateScreenDataTable(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n\nALUMNOS");
        sb.append(String.format("\n|%32s|%5s|%9s|%9s|%10s|%6s|%5s|","Nombre y Apellidos","edad","NIF","DNI","Calle","Numero","Letra"));
        
        if(null == this.alumnos || this.alumnos.isEmpty()){
            sb.append("\n\t\t\tNo se tienen registros todavia");
        }else{
            for(DatosDeAlumno a : this.alumnos){
                sb.append(a.toString());
            }
        }
        
        return sb.toString();
    }
    
    
    public List<DatosDeAlumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(List<DatosDeAlumno> alumnos) {
        this.alumnos = alumnos;
    }
}
