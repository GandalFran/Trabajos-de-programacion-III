/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros.Exceptions;

/**
 *
 * @author franp
 */
public class SortNotFoundException extends Exception {

    public SortNotFoundException() {
        super("Type of sort not found");
    }
}
