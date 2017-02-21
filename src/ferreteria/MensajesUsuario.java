/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.io.IOException;

/**
 *
 * @author marianacr
 */
public class MensajesUsuario {
    
    public void menu() {
    System.out.println("----------SISTEMA DE FERRETERIA---------");
    System.out.println("1. Agregrar articulo a inventario");
    System.out.println("2. Eliminar articulo de inventario");
    System.out.println("3. Modificar información de un articulo");
    System.out.println("4. Mostrar inventario completo");
    System.out.println("5. Mostrar inventario ordenado por nombre");
    System.out.println("6. Mostrar inventario ordenado por clave");
    System.out.println("7. Buscar articulo por nombre");
    System.out.println("8. Buscar articulo por clave");
    System.out.println("9. Buscar articulo por descripción");
    System.out.println("10.Mostrar costo del inventario");
    System.out.println("11.Realizar venta");
    System.out.println("0.Salir");
  }
    
    public int leerOpcion(){
        Teclado tec = new Teclado();
        System.out.println("¿Cual es tu opcion?");
        return tec.leerEntero();
    }
    
    public void realizarOpcion(int op) throws IOException, ClassNotFoundException{
        
    Articulo art = new Articulo();
    Inventario in = new Inventario();
    Teclado tec = new Teclado();
        switch(op){
            case 1: 
                art.leerDatos();
                try{
                in.agregarArticulo(art);
                }catch(NullPointerException e){
                    e.getMessage();
                }
                break;
            case 2:
                System.out.println("Ingrese la clave del articulo que desea eliminar");
                art.clave = tec.leerEntero();
                in.eliminarArticulo(art.clave);
               
                break;
            case 3:
                System.out.println("Ingrese la clave del articulo que desea modificar: ");
                art.clave = tec.leerEntero();
                art.leerDatos();
                in.modificarArticulo(art.clave, art);
                break;
            case 4: 
                try{
               in.mostrarTodo();
                }catch(NullPointerException e){
                    e.getMessage();
                }
                break;
            case 5:
                try{
                in.mostrarNombre();
                }catch(NullPointerException e){
                    e.getMessage();
                }
                break;
            case 6: 
                try{
                    in.mostrarClave();
                }catch(NullPointerException e){
                    e.getMessage();
                }
               
                break;
            case 7:
                String nombre;
                System.out.println("Ingrese el nombre del articulo que desea consultar: ");
                nombre = tec.leerString();
                in.buscarNombre(nombre);
                break;
            case 8:
                System.out.println("Ingrese la clave del articulo que desea consultar: ");
                art.clave = tec.leerEntero();
                in.buscarClave(art.clave);
                break;
            case 9: 
                String descripcion;
                System.out.println("Ingrese la descripcion del articulo que desea consultar: ");
                descripcion = tec.leerString();
                in.buscarDescripcion(descripcion);
                break;
            case 10: 
                in.precioInventario();
                break;
            case 11:
                System.out.println("Ingrese la clave del articulo a vender: ");
                art.clave = tec.leerEntero();
                in.venderArticulo(art.clave);
                break;
            case 0: 
                System.out.println("Hasta luego :)");
                break;
            
        }
}
}
