/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource.readers;

import java.io.IOException;
import java.util.Set;
import su.jet.javacource.User;

/**
 *
 * @author kurmesov
 */
public interface Reader {
    Set<User> read() throws IOException ;
}
