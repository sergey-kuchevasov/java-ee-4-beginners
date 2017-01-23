/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource.writers;

import java.util.Set;
import su.jet.javacource.User;
import su.jet.javacource.writers.exception.DataWriteException;

/**
 *
 * @author kurmesov
 */
public interface Writer {


    void write(Set<User> users) throws DataWriteException;
}
