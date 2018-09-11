/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Data;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import otros.TipoSort;

/**
 *
 * @author franp
 */
public class Controller {
    private Data d = new Data();
    private FileHandler fh = new FileHandler();
    
    public void addTrabajador(String[] data) throws ParseException{
        d.addTrabajador(data);
    }

    public String[] getTrabajador(int dni){
        return d.searchTrabajador(dni);
    }

    public void editTrabajador(int dniAntiguo, String[] data) throws ParseException{
        d.editTrabajador(dniAntiguo,data);
    }

    public void exportData() throws IOException{
        fh.exportHtml(d.getHtmlData());
        fh.exportCsv(d.getCsvData());
        fh.exportBinary(d.getTrabajadores());
    }

    public void generateRandomTrabajadores(int num) {
        d.generateRandomData(num);
    }

    public void deleteTrabajador(int dni) {
        d.deleteTrabajador(dni);
    }

    public boolean existeTrabajador(int dni) {
        return d.existeTrabajador(dni);
    }

    public void sortData(TipoSort sort) {
        d.sortTrabajadores(sort);
    }

    public List<String> getAllFormattedData() {
        return d.getAllData();
    }

    
}
