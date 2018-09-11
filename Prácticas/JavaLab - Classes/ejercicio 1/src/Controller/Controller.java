/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;

/**
 *
 * @author franp
 */
public class Controller {
 
    private Model m = new Model();
    
    public void sumarNumeros(){
        m.setResult(m.getNum1() + m.getNum2());
    }
    
    public int getNum1() {
        return m.getNum1();
    }
    public void setNum1(int num1) {
         m.setNum1(num1);
    }
    public int getNum2() {
        return m.getNum2();
    }
    public void setNum2(int num2) {
        m.setNum2(num2);
    }
    public int getResult(){
        return m.getResult();
    }
    public void setResult(int result){
        m.setResult(result);
    }
}
