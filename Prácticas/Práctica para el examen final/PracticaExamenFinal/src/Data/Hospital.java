/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.Comparators.ComparadorPorApellidosYNombreMed;
import Data.Comparators.ComparadorPorApellidosYNombrePac;
import Data.Comparators.ComparadorPorDni;
import Data.Comparators.ComparadorPorEspecialidad;
import Data.Comparators.ComparadorPorIngreso;
import Data.Comparators.ComparadorPorPlanta;
import Otros.Exceptions.SortNotFoundException;
import Otros.Enums.tipoSortMedico;
import Otros.Enums.tipoSortPaciente;
import static Otros.Enums.tipoSortPaciente.DNI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author franp
 */
public class Hospital {
    private List<Medico>medicos;
    private List<Paciente>pacientes;
    private Set<Integer>conjuntoMedicos;
    private Set<Integer>conjuntoPacientes;
    
    public Hospital(){
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        conjuntoMedicos = new HashSet<>();
        conjuntoPacientes = new HashSet<>();
    }
    
    
    public boolean addPaciente(String[]data){
        Paciente p = Paciente.instanceFromStringArray(data);
        pacientes.add(p);
        return conjuntoPacientes.add(p.getDni());
    }
    public boolean addMedico(String[]data){
        Medico m = Medico.instanceFromStringArray(data);
        medicos.add(m);
        return conjuntoMedicos.add(m.getCodigo());
    }
    public boolean addIngreso(String[]data){
        Paciente pa = new Paciente(Integer.parseInt(data[0]));
        Collections.sort(this.pacientes,new ComparadorPorDni());
        int pos = Collections.binarySearch(this.pacientes,pa,new ComparadorPorDni());
        if(0 > pos) return false;
        return this.pacientes.get(pos).annadirIngreso(data);
    }
    
    public List<String> getAllPacienteInfo(){
        System.err.println(this.pacientes);
        List<String> lista = new ArrayList<>();
        for(Paciente p : this.pacientes)
            lista.add(p.toString());
        return lista;
    }
    public List<String> getAllPacienteInfoHtml(){
        List<String> lista = new ArrayList<>();
        for(Paciente p : this.pacientes)
            lista.add(p.toHtmlString());
        return lista;
    }
    public List<String> getAllPacienteInfoCsv(){
        List<String> lista = new ArrayList<>();
        for(Paciente p : this.pacientes)
            lista.add(p.toCsvString());
        return lista;
    }
    
    public void sortPacientes(tipoSortPaciente sort) throws SortNotFoundException{
        Comparator<Paciente> c = null;
        switch(sort){
            case DNI: c = new ComparadorPorDni(); break;
            case ApellidosYNombre: c = new ComparadorPorApellidosYNombrePac(); break;
            case ultimoIngreso: c = new ComparadorPorIngreso(); break;
        }
        if(null == c) throw new SortNotFoundException();
        Collections.sort(this.pacientes,c);
    }
    public void sortMedicos(tipoSortMedico sort) throws SortNotFoundException{
        Comparator<Medico> c = null;
        switch(sort){
            case ApellidosYNombre: c = new ComparadorPorApellidosYNombreMed(); break;
            case especialidad: c = new ComparadorPorEspecialidad(); break;
            case planta: c = new ComparadorPorPlanta(); break;
        }
        if(null == c) throw new SortNotFoundException();
        Collections.sort(this.medicos,c);
    }
    
    public boolean existeMedico(int codigo) {
        return this.conjuntoMedicos.contains(codigo);
    }
    public boolean existePaciente(int dni) {
        System.out.println(conjuntoPacientes);
        return this.conjuntoPacientes.contains(dni);
    }

    public List<Medico> getMedicos() {
        return medicos;
    }
    public List<Paciente> getPacientes() {
        return pacientes;
    }
    
    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
        for(Paciente p: pacientes)
            this.conjuntoPacientes.add(p.getDni());
    }
}
