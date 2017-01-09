/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.edu;

import static com.acme.edu.Calculator.add;
import static com.acme.edu.Calculator.getResult;
/**
 *
 * @author eugene
 */
public class Main {
    public static void main(String[] args) {
        Calculator.add(1, 1);
        
        Calculator calculator = new Calculator();
        calculator = null;
        calculator.getResult();
        
        System.out.println(getResult());
    }
}

class Calculator {
    private static int result;
    
    public static void add(int a, int b) {
        result = a + b;
    }
    
    public static int getResult() {
        return result;
    }
}


