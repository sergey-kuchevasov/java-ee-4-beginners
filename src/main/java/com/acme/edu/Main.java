/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.edu;

/**
 *
 * @author eugene
 */
public class Main {   
    public static strictfp void main(String[] args) {
        byte b = 0; //0..255 | -128..127
        short s = 0; 
        int i = 0;
        long l = 999999999999L;
        
        for(int counter = 0; counter < 200; counter++) {
            b++;
        }
        System.out.println(b);
        
        int ii = 0555;
        char c = '\r';
        
        float f = 0.0F;
        double d = 1e4;
        System.out.println(.1 +.2); //IEEE 
        
        boolean bb = true | false;    
        
    }
}

class Employee {
    int id;
}


