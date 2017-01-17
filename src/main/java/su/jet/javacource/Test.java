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
import su.jet.javacource.readers.StubReader;

/**
 *
 * @author kurmesov
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File f = new File("c:/work/temp/users.csv");
        System.out.println(f.exists());
   
        DataLoader dataLoader = new DataLoader(
                new DataSource[] {new StubDataSource("DB"), new StubDataSource("LDAP")},
                new CsvReader(f)
        );
        dataLoader.load();
    }
}
