/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource.writers.exception;

/**
 *
 * @author kurmesov
 */
public class DataWriteException extends Exception {

    public DataWriteException(String message, Exception ex) {
        super(message, ex);
    }

}
