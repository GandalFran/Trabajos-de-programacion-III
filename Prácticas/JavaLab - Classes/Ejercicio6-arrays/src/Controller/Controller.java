/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Constantes;
import Model.DatosDeAlumno;
import Model.DatosDireccion;
import Model.DatosPersonales;
import Model.Model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franp
 */
public class Controller {
    
    private final Model m = new Model();
    
    
    public void generateRandomListOfStudents(){
        m.generateAlumnos(Constantes.NUM_ALUMNOS);
    }
    
    public List<String> getTablaDatosPersonales(){
        List<String> lista = new ArrayList();
        DatosDireccion d = null;
        DatosPersonales p = null;
        
        lista.add("<h1>Datos personales de alumnos</h1>\n");
        lista.add("<table>\n");
        lista.add("<tr>  <td><strong>DNI</strong></td> <td><strong>Calle</strong></td> <td><strong>Numero</strong></td> <td><strong>Letra</strong></td>  </tr>\n");
        
        for(DatosDeAlumno a : m.getAlumnos()){
            d=a.getDireccion();
            p=a.getPersonales();
            lista.add(String.format("\n<TR> <TD>%9s</TD> <TD>%10s</TD> <TD>%3d</TD> <TD>%3s</TD> </TR>",d.getDNI(),d.getCalle(),d.getNumero(),d.getLetra()));
        }
        
        lista.add("</table>");
        
        return lista;
    }
    
    public List<String>getTablaDirecciones(){
        List<String> lista = new ArrayList();
        DatosDireccion d = null;
        DatosPersonales p = null;
        
        lista.add("<h1>Direcciones de alumnos</h1>\n");
        lista.add("<table>\n");
        lista.add("<tr>  <td><strong>Nombre y Apellidos</strong></td> <td><strong>edad</strong></td> <td><strong>NIF</strong></td>  </tr>\n");
        
        for(DatosDeAlumno a : m.getAlumnos()){
            d=a.getDireccion();
            p=a.getPersonales();
            lista.add(String.format("\n<TR> <TD>%20s, %10s</TD> <TD>%5d</TD> <TD>%9s</TD> </TR>",p.getApellidos(),p.getNombre(),p.getEdad(),p.getNIF()));
        }
        
        lista.add("</table>");
        
        return lista;
    }
    
    public String generateTable(){
        StringBuilder sb = new StringBuilder();
        
        DatosDireccion d = null;
        DatosPersonales p = null;
        sb.append("\n\nALUMNOS");
        sb.append(String.format("\n|%32s|%5s|%9s|%9s|%10s|%3s|%3s|","Nombre y Apellidos","edad","NIF","DNI","Calle","Numero","Letra"));
        for(DatosDeAlumno a : m.getAlumnos()){
            d=a.getDireccion();
            p=a.getPersonales();
            sb.append(String.format("\n|%20s, %10s|%5d|%9s|%9s|%10s|%3d|%3s|",p.getApellidos(),p.getNombre(),p.getEdad(),p.getNIF(),d.getDNI(),d.getCalle(),d.getNumero(),d.getLetra()));
        }
        
        return sb.toString();
    }
    
}
