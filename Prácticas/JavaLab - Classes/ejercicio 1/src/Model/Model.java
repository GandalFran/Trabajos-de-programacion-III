/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author franp
 */
public class Model {
    private int num1;
    private int num2;
    private int result;
    
    public Model(){
        this.num1=0;
        this.num2=0;
        this.result=0;
    }
     
    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public int getResult(){
        return this.result;
    }
    public void setResult(int result){
        this.result=result;
    }
    
}
