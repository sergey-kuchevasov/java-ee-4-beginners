/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

import su.jet.javacource.writers.Writer;

/**
 *
 * @author kurmesov
 */
public interface DataSource {
    String getType();
    Writer getWriter();
    
}
