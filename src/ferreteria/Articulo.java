
package ferreteria;
import java.io.*;
/**
 *
 * @author marianacr
 */
public class Articulo implements Serializable {
  private String nombre;
  public int clave;
  private String descripcion;
  private int existencia;
  private double precioCompra;
  private String tipoUnidad;
    
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public void  setClave(int clave){
      this.clave = clave;
  }
  
  public int getClave(){
      return clave;
  }
  

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getExistencia() {
    return existencia;
  }

  public void setExistencia(int existencia) {
    this.existencia = existencia;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  public void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  public String getTipoUnidad() {
    return tipoUnidad;
  }

  public void setTipoUnidad(String unidadMedida) {
    this.tipoUnidad = unidadMedida;
  }

  public Articulo (){}
 /**
  * Constructor de Articulo
  * @param nombre
  * @param descripcion
  * @param existencia
  * @param precioCompra
  * @param tipoUnidad
  * @param clave
  * @throws IOException 
  */
  public Articulo(String nombre, String descripcion, int existencia, double precioCompra, String tipoUnidad, int clave) throws IOException{
    this.clave = clave;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.existencia = existencia;
    this.precioCompra = precioCompra;
    this.tipoUnidad = tipoUnidad;
  }
  
  /**
   * Para escribir el objeto
   * @param out
   * @throws IOException 
   */
  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
  }
/**
 * Para leer el objeto
 * @param in
 * @throws IOException
 * @throws ClassNotFoundException 
 */
  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
  }
/**
 * Se sobreescribe el método de toString del objeto para que imprima sus atributos
 * @return 
 */
  @Override
  public String toString() {
	return("Clave: " + clave + "\nName: " + nombre + "\n" + "Descripción: " + descripcion + "\n" + "Existencia: " + existencia  + "\n" + tipoUnidad + "\n" + "Precio de compra: " + precioCompra + "\n");
    }
  
  
  public void leerDatos() throws IOException{
     
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Ingrese la clave del articulo");
      clave = Integer.parseInt(in.readLine());
      System.out.println("Ingrese el nombre del articulo");
      nombre = in.readLine();
      System.out.println("Ingrese la descripcion");
      descripcion = in.readLine();
      System.out.println("Ingrese el precio de compra");
      precioCompra = Double.parseDouble(in.readLine()); 
      System.out.println("Ingrese la existencia del articulo");
      existencia =  Integer.parseInt(in.readLine());
      System.out.println("Ingrese el tipo de unidad del articulo");
      tipoUnidad = in.readLine();
      Articulo art = new Articulo(nombre, descripcion, existencia, precioCompra, tipoUnidad, clave);
  }
}
