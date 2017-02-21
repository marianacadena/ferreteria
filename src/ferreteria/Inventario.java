
package ferreteria;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author marianacr
 */
public class Inventario {
    
  public Articulo articulo;
  ArchInventario archivo = new ArchInventario();
  public ArrayList<Articulo> articulos;
  Teclado tec = new Teclado();
  int clave;
  
    
    public Inventario() throws FileNotFoundException, IOException {
    if (archivo.existeArticulo()) {
      articulos = archivo.readFile();
      clave = articulos.size();
    } else {
      articulos = new ArrayList();
    }
    
  }

  public void agregarArticulo(Articulo articulo) throws IOException {
        articulos.add(articulo);
        archivo.writeFile(articulos);
        System.out.println("Articulo registrado con exito");
  }

  public void eliminarArticulo(int clave) throws IOException { 
    for(Articulo actual : articulos) {
      if(actual.clave == clave) {
        articulos.remove(actual);
        break;
      }
    }
    archivo.writeFile(articulos);
  }

  public void mostrarTodo() {
      if(articulos.isEmpty()){
        System.out.println("No hay articulos registrados en el inventario");
      }else{
    for(Articulo actual : articulos) {
            System.out.println(actual);
        }
      }
    }
  
  
  public void buscarNombre(String nombre){
      for(Articulo actual : articulos){
          if(actual.getNombre().equals(nombre)){
              System.out.println(actual);
          }
      }
  }
  
  public void buscarClave(int clave){
      for(Articulo actual : articulos){
          if(actual.clave == clave){
              System.out.println(actual);
          }
      }
  }
  
  public void buscarDescripcion(String descripcion){
      for(Articulo actual : articulos){
          if(actual.getDescripcion().equals(descripcion)){
              System.out.println(actual);
          }
      }
  }
  
  public void mostrarNombre(){
    Collections.sort(articulos, new Comparator<Articulo>() {
      @Override
      public int compare(Articulo a1, Articulo a2) {
        return a1.getNombre().compareTo(a2.getNombre());
      }
    });
    for (int i = 0; i < articulos.size(); i++) {
      System.out.println(i+1+") Nombre: "+articulos.get(i).getNombre());
      System.out.println("Clave: "+articulos.get(i).getClave());
      System.out.println("Descripcion: "+articulos.get(i).getDescripcion());
      System.out.println("Precio: "+articulos.get(i).getPrecioCompra());
      System.out.println("Existencia: "+articulos.get(i).getExistencia());
      System.out.println("Tipo de unidad"+articulos.get(i).getTipoUnidad());
      System.out.println("--------------------------------");
    }
  }
  
  public void mostrarClave(){
      Collections.sort(articulos, new Comparator<Articulo>(){
          @Override
          public int compare(Articulo art1, Articulo art2){
              return new Integer(art1.getClave()).compareTo(art2.getClave());
          }
      });
      for (int i = 0; i < articulos.size(); i++) {
      System.out.println(i+1+") Nombre: "+articulos.get(i).getNombre());
      System.out.println("Clave: "+articulos.get(i).getClave());
      System.out.println("Descripcion: "+articulos.get(i).getDescripcion());
      System.out.println("Precio: "+articulos.get(i).getPrecioCompra());
      System.out.println("Existencia: "+articulos.get(i).getExistencia());
      System.out.println("Tipo de unidad"+articulos.get(i).getTipoUnidad());
      System.out.println("--------------------------------");
      }
  }

  public void modificarArticulo(int clave, Articulo articulo) throws IOException {
    for(Articulo actual : articulos) {
      if(actual.clave == clave) {
        articulos.remove(actual);
        articulos.add(articulo);
      }
    }
    archivo.writeFile(articulos);
  }
  
  public void precioInventario(){
      double suma=0;
      for(Articulo actual : articulos){
          suma = suma +(actual.getPrecioCompra()*actual.getExistencia());
      }
      System.out.println("El precio total del inventario es: " + suma);
  }
  
  public void venderArticulo(int clave) throws IOException{
      int cantidad;
      double venta;
      for(Articulo actual : articulos){
          if(actual.clave == clave){
          if(actual.getExistencia()>=0){
              System.out.println("Cantidad de venta: ");
              cantidad = tec.leerEntero();
              if(actual.getExistencia()>=cantidad){
              venta = (((actual.getPrecioCompra()*0.5)*0.16)*cantidad);
              System.out.println("Total de venta: " + venta);
              actual.setExistencia(actual.getExistencia()-cantidad); 
              System.out.println("Venta realizada con exito");
              }
          }
      }
      }
      archivo.writeFile(articulos);
  }
}

    
