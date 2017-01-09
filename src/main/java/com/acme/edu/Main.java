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
    public static void main(String[] args) {
	while(true) {
		new DataStruct(); 
	}
    }
}

class DataStruct {
	private int property = 0;
	private DataStruct next = null;
	long[] loadArray = new long[10_000_000];
}
