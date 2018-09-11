package Controller;

import Data.Model;
import Others.Constantes;

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
        return m.getAllBills();
    }

    public void generateRandomValues() {
        m.generateRandomBills(Constantes.NUM_RANDOM_BILLS);
    }
}
