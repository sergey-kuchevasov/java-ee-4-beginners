/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource;

import java.util.List;

/**
 *
 * @author kurmesov
 */
public class StubReader implements Reader{

    @Override
    public User[] read() {
        System.out.println("reading users");
        User[] u = {new User(1, "Ivanov"), new User(2, "Petrov")};
        return u;
    }
    
}
