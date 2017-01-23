/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

import su.jet.javacource.writers.DbWriter;
import su.jet.javacource.writers.Writer;

/**
 *
 * @author kurmesov
 */
public class DerbyDbDataSource implements DataSource {

    private String connectionString;
    private String user;
    private String password;

    public DerbyDbDataSource(String connectionString, String user, String password) {
        this.connectionString = connectionString;
        this.user = user;
        this.password = password;
    }

    @Override
    public String getType() {
        return "DB";
    }

    @Override
    public Writer getWriter() {
        return new DbWriter(connectionString, user, password);
    }

}
