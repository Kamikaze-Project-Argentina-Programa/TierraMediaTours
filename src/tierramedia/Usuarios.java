package tierramedia;

public class Usuarios {
  protected String nombre;
  protected String monedas;
  protected String tiempo; 
  protected String atraccion;  // tipo preferida
public Usuarios(String nombre, String tipo, String monedas, String tiempo ) {
	super();
	this.nombre = nombre;
	this.monedas = monedas;
	this.tiempo = tiempo;
	this.atraccion = tipo;
}
@Override
public String toString() {
	return "Usuario: " + nombre + " Presupuesto: " + monedas + " monedas. Tiene " + tiempo + " horas y le gusta hacer: " + atraccion + ".";
}


}
