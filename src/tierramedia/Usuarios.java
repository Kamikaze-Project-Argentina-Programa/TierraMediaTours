package tierramedia;

import java.util.Objects;

public class Usuarios {
  protected String nombre;
  protected int monedas;
  protected double tiempo; 
  protected String tipoAtraccion;  // tipoAtraccion preferida
public Usuarios(String nombre, String tipo, int monedas, double tiempo ) {
	super();
	this.nombre = nombre;
	this.monedas = monedas;
	this.tiempo = tiempo;
	this.tipoAtraccion = tipo;
}
@Override
public String toString() {
	return "Usuario: " + nombre + " Presupuesto: " + monedas + " monto. Tiene " + tiempo + " horas y le gusta hacer: " + tipoAtraccion + ".";
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
	System.out.println("Bienvenidx " + usuario.getNombre() + "!!");
	System.out.println("¿Te gustan las atracciones de tipo " + usuario.getTipo() + "?");
	System.out.println("¡Entonces tenemos estas promos para vos!");
	System.out.println("-------------");
}


public String getNombre() {
	return nombre;
}
public String getTipo() {
	return tipoAtraccion;
}
public void setMonedas(int monedas) {
	this.monedas = monedas;
}

@Override
public int hashCode() {
	return Objects.hash(tipoAtraccion, monedas, nombre, tiempo);
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
	return Objects.equals(tipoAtraccion, other.tipoAtraccion) && monedas == other.monedas
			&& Objects.equals(nombre, other.nombre)
			&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo);
}

}
