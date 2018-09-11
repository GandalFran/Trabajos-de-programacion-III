package Controller;

import Data.HardDisk;
import Data.Model;
import Others.Constantes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franp
 */
public class Controller {
    private Model m = new Model();
    
    public String[][] getAllBillData() {
        return m.getAllHdds();
    }

    public void generateRandomValues() {
        m.generateRandomHdds(Constantes.NUM_RANDOM_HDDS);
    }
    
    public void importData() throws IOException{
        File f = new File(Constantes.RUTA_FICHERO);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
        
        try {
            m.setHds((List<HardDisk>)ois.readObject());
        } catch (ClassNotFoundException ex) {
            throw new IOException();
        }
        
        ois.close();
    }
    
    public void exportData( ) throws IOException{
        File f = new File(Constantes.RUTA_FICHERO);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
        
        oos.writeObject(m.getHds());
        oos.close();
    }

    public void sortData() {
        m.sortHds();
    }
}
