/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kurmesov
 */
public class DataLoader {

    private DataSource[] dataSources;
    private Reader reader;


    public DataLoader(DataSource[] dataSources, Reader reader) {
        this.dataSources = dataSources;
        this.reader = reader;
    }

    public void load() {
        User[] users = reader.read();
        System.out.println((users == null ? "0" : users.length) +" users was read");
        for (DataSource dataSource : dataSources) {
            System.out.println("handling datasource:"+dataSource.getType());
            for (User user : users) {
                if (user == null) continue;
                System.out.println("handling user"+user.toString());
                Writer writer = dataSource.getWriter();
                writer.write(user);
                
           
            }
        }
    }

}
