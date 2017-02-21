/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author marianacr
 */
public class Ferreteria {

    /**
     * @param args
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       Teclado tec = new Teclado();
       MensajesUsuario mens = new MensajesUsuario();
       
               
       
       int op = 0;
    
    do {
      mens.menu();
      try {
        op = mens.leerOpcion();
      } catch (NumberFormatException e) {
      }
      mens.realizarOpcion(op);

    } while (op != 0);

    }
 
    
}
