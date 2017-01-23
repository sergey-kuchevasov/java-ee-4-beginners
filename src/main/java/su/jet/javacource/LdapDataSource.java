/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

import su.jet.javacource.writers.LdapWriter;
import su.jet.javacource.writers.Writer;

/**
 *
 * @author kurmesov
 */
public class LdapDataSource implements DataSource {

    private String provUrl;
    private String user;
    private String pwd;

    public LdapDataSource(String providerUrl, String user, String password) {
        this.provUrl = providerUrl;
        this.user = user;
        this.pwd = password;
    }

    @Override
    public String getType() {
        return "LDAP";
    }

    @Override
    public Writer getWriter() {
        return new LdapWriter(this.provUrl, this.user, this.pwd);
    }

}
