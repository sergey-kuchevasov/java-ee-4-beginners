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
import java.util.logging.Level;
import java.util.logging.Logger;
import su.jet.javacource.User;

/**
 *
 * @author kurmesov
 */
public class CsvReader implements Reader {


    private final BufferedReader bufferedReader;

    public CsvReader(File filePath) throws FileNotFoundException {

        this.bufferedReader = new BufferedReader(new InputStreamReader((new FileInputStream(filePath))));

    }

    @Override
    public User read() throws IOException {

        String line = bufferedReader.readLine();
        if (line != null) {
            String[] splitedLine = line.split(",");
            return new User(Integer.parseInt(splitedLine[0]), splitedLine[1]);
        } else {
            return null;
        }

    }

}
