/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author marianacr
 */
public class ArchInventario {
  File archivo;
  FileOutputStream fi;
  ObjectOutputStream out;
  ObjectInputStream intp;
  FileInputStream fiput;
  
  public ArchInventario(){
      archivo = new File("Contador.txt");
  }
  
  public void writeFile(ArrayList<Articulo> articulos) throws FileNotFoundException, IOException{
      fi = new FileOutputStream(archivo);
      out= new ObjectOutputStream(fi);
      out.writeObject(articulos);
      out.close();
      
  }
  public ArrayList<Articulo> readFile(){
    ArrayList<Articulo> articulos = null;

    try {
      fiput = new FileInputStream(archivo);
      intp = new ObjectInputStream(fiput);
      articulos = (ArrayList<Articulo>) intp.readObject();
      intp.close();
    } catch (FileNotFoundException e) {
      System.out.println("Archivo no encontrado");
    } catch (IOException e) {
      System.out.println("Error de salida");
    } catch (ClassNotFoundException e) {
      System.out.println("Error de clase");
    }
    if(articulos == null)
          System.out.println("es null");
    return articulos;
  }
  
  public boolean existeArticulo(){
      try{
      fiput = new FileInputStream(archivo);
      return true;
    } catch (FileNotFoundException ex) {
      return false; 
    }
  }
}
