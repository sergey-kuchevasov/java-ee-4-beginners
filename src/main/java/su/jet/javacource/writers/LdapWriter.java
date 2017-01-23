/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource.writers;

import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import su.jet.javacource.User;
import su.jet.javacource.writers.exception.DataWriteException;

/**
 *
 * @author kurmesov
 */
public class LdapWriter implements Writer {

    private String providerUrl;
    private String user;
    private String pwd;

    public LdapWriter(String providerUrl, String user, String password) {
        this.providerUrl = providerUrl;
        this.user = user;
        this.pwd = password;
    }

    @Override
    public void write(Set<User> users) throws DataWriteException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, providerUrl); //

        props.put(Context.SECURITY_AUTHENTICATION, "simple");
        props.put(Context.SECURITY_PRINCIPAL, this.user); //
        props.put(Context.SECURITY_CREDENTIALS, this.pwd); // 

        props.put("com.sun.jndi.ldap.connect.timeout", "5000");
        props.put("com.sun.jndi.ldap.connect.pool", "true");
        props.put("com.sun.jndi.ldap.connect.pool.debug", "fine");
        DirContext initialDirContext = null;
        try {
            initialDirContext = new InitialDirContext(props);
            for (User lUser : users) {
                System.out.println("ldap: handling user" + user.toString());
                
                String uid = Integer.toString(lUser.getId());
                String userName = lUser.getName();
                String sn = userName.substring(userName.trim().lastIndexOf(" "));
                if (userName.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                Attributes personAttributes = new BasicAttributes();
                BasicAttribute personBasicAttribute = new BasicAttribute("objectclass");
                personBasicAttribute.add("top");
                personBasicAttribute.add("person");
                personBasicAttribute.add("uidObject");
                personAttributes.put(personBasicAttribute);
                personAttributes.put("sn", sn);
                personAttributes.put("description", "description");
                personAttributes.put("uid", uid);
                
                final DirContext usersContext = (DirContext) initialDirContext.lookup("ou=users");
                usersContext.bind("cn=" + userName, "", personAttributes);
                System.out.println("success");
            }

        } catch (NamingException | IllegalArgumentException ex) {
            System.out.println("Error occured while writing to directory: " + ex);
            ex.printStackTrace();
            throw new DataWriteException("", ex);
        } finally {
            if (initialDirContext != null) {
                try {
                    initialDirContext.close();
                } catch (NamingException ex) {
                    System.out.println("Error occured while closing ldap context");
                    throw new DataWriteException("Error occured while closing ldap context", ex);
                }
            }
        }
    }

}
