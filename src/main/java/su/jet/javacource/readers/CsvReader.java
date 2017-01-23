/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import su.jet.javacource.User;

/**
 *
 * @author kurmesov
 */
public class CsvReader implements Reader {

    private final BufferedReader bufferedReader;
    private final int batchSize;
    private int currentLineNumber;

    public CsvReader(File filePath, int batchSize) throws FileNotFoundException {

        this.bufferedReader = new BufferedReader(new InputStreamReader((new FileInputStream(filePath))));
        this.batchSize = batchSize;

    }

    @Override
    public Set<User> read() throws IOException {

        String line = null;
        String[] splitedLine;
        Set<User> users = new HashSet<>();

        try {
            while ((line = bufferedReader.readLine()) != null) {
                this.currentLineNumber++;
                splitedLine = line.split(",");
                try {
                users.add(new User(Integer.parseInt(splitedLine[0]), splitedLine[1]));
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
                    System.out.println("Error while parsing file. skiping line num "+this.currentLineNumber+": "+line);
                }
                if (users.size() == batchSize) {
                    break;
                }
            }
            return users;
        } finally {
            if ((line == null) && (this.bufferedReader != null)) {
                this.bufferedReader.close();
            }
        }

    }

}
