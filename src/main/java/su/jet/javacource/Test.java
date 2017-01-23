/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import su.jet.javacource.readers.CsvReader;

/**
 *
 * @author kurmesov
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("c:/work/temp/users.csv");
        System.out.println(file.exists());
        try {
            DataLoader dataLoader = new DataLoader(
                    new DataSource[]{new DerbyDbDataSource("jdbc:derby://localhost/example;create=true", "app", "app"), new LdapDataSource("ldap://localhost:10389/ou=system", "uid=admin,ou=system", "secret")},
                    new CsvReader(file, 10)
            );
            dataLoader.load();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }
}
