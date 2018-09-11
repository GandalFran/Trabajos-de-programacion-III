/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Otros.Exceptions.SortNotFoundException;
import Data.Hospital;
import Otros.Constantes;
import Otros.Enums.tipoSortMedico;
import Otros.Enums.tipoSortPaciente;
import java.io.IOException;

/**
 *
 * @author franp
 */
public class Controller {
    private Hospital h = new Hospital();
    private FileHandler fh = new FileHandler();
    
    public void addPaciente(String[]data){
        h.addPaciente(data);
    }
    public void addMedico(String[] data) {
        h.addMedico(data);
    }
    public void addIngreso(String[] data) {
        h.addIngreso(data);
    } 
    
    public void exportarPacientes() throws IOException{
        fh.exportAsHtml(Constantes.RUTA_PACIENTES_HTML,h.getAllPacienteInfoHtml(),Constantes.HTML_TITLE,Constantes.HTML_HEADER);
        fh.exportAsCsv(Constantes.RUTA_PACIENTES_CSV,h.getAllPacienteInfoCsv());
        fh.exportAsTxt(Constantes.RUTA_PACIENTES_TXT,h.getAllPacienteInfo());
        fh.saveBinary(Constantes.RUTA_PACIENTES_BIN,h.getPacientes());
    }
    public void importarPacientes() throws IOException{
        if(fh.exists(Constantes.RUTA_PACIENTES_BIN)){
            h.setPacientes(fh.loadBinary(Constantes.RUTA_PACIENTES_BIN));
        }else if(fh.exists(Constantes.RUTA_PACIENTES_TXT)){
            String[][]dataPacientes = fh.parseTxt(fh.imporTxtData(Constantes.RUTA_PACIENTES_TXT));
            for(String[]f : dataPacientes)
                h.addPaciente(f);
        }else{
            throw new IOException();
        }
    }

    public void ordenarPacientes(tipoSortPaciente sort) throws SortNotFoundException{
        h.sortPacientes(sort);
    }
    public void ordenarMedicos(tipoSortMedico sort) throws SortNotFoundException{
        h.sortMedicos(sort);
    }
    
    public boolean existeMedico(int codigo){
        return h.existeMedico(codigo);
    }
    
    public boolean existePaciente(int dni){
        return h.existePaciente(dni);
    }
}
