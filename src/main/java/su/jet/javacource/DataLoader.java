/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import su.jet.javacource.readers.Reader;
import su.jet.javacource.writers.Writer;

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

    public void load() throws IOException {
        Set<User> users;
        int cnt = 0;
        try {
            while ((users = reader.read()) != null) {
                cnt++;
                System.out.println("iterating "+cnt+" batch");
                for (DataSource dataSource : dataSources) {
                    Iterator usersIterator = users.iterator();
                    while (usersIterator.hasNext()) {
                        User user = (User) usersIterator.next();
                        System.out.println("handling datasource:" + dataSource.getType());
                        System.out.println("handling user" + user.toString());
                        Writer writer = dataSource.getWriter();
                        writer.write(user);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Невозможно прочитать строку");
        }
    }

}
