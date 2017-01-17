/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

import su.jet.javacource.writers.StubWriter;
import su.jet.javacource.writers.Writer;

/**
 *
 * @author kurmesov
 */
public class StubDataSource implements DataSource {

    private final String dsType;

    StubDataSource(String dsType) {
        this.dsType = dsType;
    }
    @Override
    public String getType() {
        return this.dsType;
    }

    
    @Override
    public Writer getWriter() {
        return new StubWriter();
    }

}
