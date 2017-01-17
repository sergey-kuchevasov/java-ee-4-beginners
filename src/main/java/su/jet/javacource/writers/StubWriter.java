/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource.writers;

import su.jet.javacource.User;
import su.jet.javacource.writers.Writer;

/**
 *
 * @author kurmesov
 */
public class StubWriter implements Writer {

    @Override
    public void write(User user) {
        System.out.println("Writing user"+user+"\nSucess.");
        return;
    }
    
}
