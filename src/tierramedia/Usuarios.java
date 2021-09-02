package tierramedia;

public class Usuarios {
  protected String nombre;
  protected int monedas;
  protected double tiempo; 
  protected String atraccion;  // tipo preferida
public Usuarios(String nombre, String tipo, int monedas, double tiempo ) {
	super();
	this.nombre = nombre;
	this.monedas = monedas;
	this.tiempo = tiempo;
	this.atraccion = tipo;
}
@Override
public String toString() {
	return "Usuario: " + nombre + " Presupuesto: " + monedas + " monto. Tiene " + tiempo + " horas y le gusta hacer: " + atraccion + ".";
}
protected int getMonedas() {
	return monedas;
}

protected double getTiempo() {
	return tiempo;
}
protected void setTiempo(double tiempo) {
	this.tiempo = tiempo;
	/// va a faltar restar cuando haga algo
}


}
