package tierramedia;

import java.util.Objects;

public class Usuarios {
  protected String nombre;
  protected int monedas;
  protected double tiempo; 
  protected String atraccion;  // tipoAtraccion preferida
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


protected static void darBienvenida(Usuarios usuario) {
	System.out.println("Bienvenidx " + usuario.nombre + "!!");
	System.out.println("¿Te gustan las atracciones de tipo " + usuario.atraccion + "?");
	System.out.println("¡Entonces tenemos estas promos para vos!");
	System.out.println("-------------");
}


@Override
public int hashCode() {
	return Objects.hash(atraccion, monedas, nombre, tiempo);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Usuarios other = (Usuarios) obj;
	return Objects.equals(atraccion, other.atraccion) && monedas == other.monedas
			&& Objects.equals(nombre, other.nombre)
			&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo);
}

}
