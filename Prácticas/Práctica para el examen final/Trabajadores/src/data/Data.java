/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.comparators.ComparadorPorsalario;
import data.comparators.ComparadorPorApellidosNombre;
import data.comparators.ComparadorPorAntiguedad;
import data.comparators.ComparadorPorDni;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import otros.TipoSort;

/**
 *
 * @author franp
 */
public class Data {
    private List<Trabajador> trabajadores = new ArrayList<>();

    public void addTrabajador(String[] data)throws ParseException{
        Trabajador t = Trabajador.instanceFromStringArray(data);
        trabajadores.add(t);
    }

    public String[] searchTrabajador(int dni) {
        Trabajador t = new Trabajador(dni);
        Collections.sort(trabajadores, new ComparadorPorDni());
        int index = Collections.binarySearch(this.trabajadores,t,new ComparadorPorDni());
        if(index>=0)
            return this.trabajadores.get(index).toStringArray();
        else
            return null;
    }

    public void editTrabajador(int dniAntiguo, String[] data)throws ParseException{
        NumberFormat nf = NumberFormat.getInstance(new Locale("es","ES"));
        Trabajador t = new Trabajador(dniAntiguo);
        Collections.sort(trabajadores, new ComparadorPorDni());
        int index = Collections.binarySearch(this.trabajadores,t,new ComparadorPorDni());
        if(index>=0){
            t = this.trabajadores.get(index);
            t.setDni(nf.parse(data[0]).intValue());
            t.setApellidos(data[1]);
            t.setNombre(data[2]);
            t.setSalario(nf.parse(data[3]).floatValue());
        }   
    }

    public void generateRandomData(int num) {
        for(int i=0; i<num; i++)
            trabajadores.add(Trabajador.instanceFromRandomValues());
    }

    public void deleteTrabajador(int dni) {
        NumberFormat nf = NumberFormat.getInstance(new Locale("es","ES"));
        Trabajador t = new Trabajador(dni);
        Collections.sort(trabajadores, new ComparadorPorDni());
        int index = Collections.binarySearch(this.trabajadores,t,new ComparadorPorDni());
        if(index>=0){
            t = this.trabajadores.get(index);
            this.trabajadores.remove(t);
        }  
    }

    public boolean existeTrabajador(int dni) {
        Trabajador t = new Trabajador(dni);
        Collections.sort(trabajadores, new ComparadorPorDni());
        int index = Collections.binarySearch(this.trabajadores,t,new ComparadorPorDni());
        return (index>=0);
    }
    
    public List<String> getHtmlData(){
        List<String>lista = new ArrayList<>();
        for(Trabajador t : this.trabajadores)
            lista.add(t.toHtmlString());
        return lista;
    }
    public List<String> getCsvData(){
        List<String>lista = new ArrayList<>();
        for(Trabajador t : this.trabajadores)
            lista.add(t.toCsvString());
        return lista;
    }
    public List<Trabajador> getTrabajadores(){
        return this.trabajadores;
    }
    public List<String> getAllData() {
       List<String>lista = new ArrayList<>();
        for(Trabajador t : this.trabajadores)
            lista.add(t.toString());
        return lista;
    }

    public void sortTrabajadores(TipoSort sort) {
        Comparator<Trabajador>c = null;
        switch(sort){
            case antiguedad: c = new ComparadorPorAntiguedad(); break;
            case salario: c = new ComparadorPorsalario(); break;
            case apellidosNombre: c = new ComparadorPorApellidosNombre(); break;
        }
        Collections.sort(this.trabajadores,c);
    }

    
    
}
