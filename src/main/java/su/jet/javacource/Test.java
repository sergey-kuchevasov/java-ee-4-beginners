/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

/**
 *
 * @author kurmesov
 */
public class Test {
    public static void main(String[] args) {
        
   
        DataLoader dataLoader = new DataLoader(
                new DataSource[] {new StubDataSource("DB"), new StubDataSource("LDAP")},
                new StubReader()
        );
        dataLoader.load();
    }
}
