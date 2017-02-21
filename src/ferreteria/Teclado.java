/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.Scanner;

/**
 *
 * @author marianacr
 */
public class Teclado {
     private Scanner sc;
    /**
     * Inicializa el objeto scanner con la entrada estandar
     * que es la lectura desde el teclado
     */
    public Teclado(){
        sc = new Scanner(System.in);
      
    }
    /**
     * Este metodo lee un valor de tipo entero
     * @return regresa un valor de tipo entero
     */
    public int leerEntero(){
    return sc.nextInt();
}
    /**
     * Este metodo lee un valor de tipo double
     * @return regresa un valor de tipo double
     */
    public Double leerDouble(){
        return sc.nextDouble();
    }
    
    public String leerString(){
        return sc.nextLine();
    }
}
