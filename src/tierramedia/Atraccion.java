package tierramedia;

import java.util.ArrayList;
import java.util.Objects;

public class Atraccion {
	protected String nombre;
	protected double monto;
	protected double tiempo;
	protected int cupo;
	protected String tipo;

	public Atraccion(String nombre, double monto, double tiempo, int cupo, String tipoAtraccion) {
		super();
		this.nombre = nombre;
		this.monto = monto;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipoAtraccion;
	}

	@Override
	public String toString() {
		return "[nombre=" + getNombre() + ", monto=" + getMonto() + ", tiempo=" + tiempo + ", cupo=" + cupo
				+ ", tipo=" + tipo + "]";
	}

	protected double getTiempo() {
		return this.tiempo;
	}

	protected int getCupo() {
		return this.cupo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public double getMonto() {
		return this.monto;
	}

	protected static void ordenarAtraccionesPorTipo() {
		LeeAtracciones.leeAtracciones();
		LeeAtracciones.getListaActividades();
		LeeAtracciones.ordenaTipoAtracciones();
		//genera tres listas
	}
	
	protected static ArrayList<Atraccion> getActiAventura() {
		return LeeAtracciones.actiAventura;
	}

	protected static ArrayList<Atraccion> getActiDegustacion() {
		return LeeAtracciones.actiDegustacion;
	}

	protected static ArrayList<Atraccion> getActiPaisaje() {
		return LeeAtracciones.actiPaisaje;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cupo, monto, nombre, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupo == other.cupo && Double.doubleToLongBits(monto) == Double.doubleToLongBits(other.monto)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& Objects.equals(tipo, other.tipo);
	}

}
