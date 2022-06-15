package cl.talentoDigital.modelo;

public class Empleado {
	private int numEmpleado;
	private String nombre;
	private int numDepto;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	
	public Empleado(int numEmpleado, String nombre, int numDepto) {
		super();
		this.numEmpleado = numEmpleado;
		this.nombre = nombre;
		this.numDepto = numDepto;
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumDepto() {
		return numDepto;
	}

	public void setNumDepto(int numDepto) {
		this.numDepto = numDepto;
	}

	@Override
	public String toString() {
		return "Empleado [numEmpleado=" + numEmpleado + ", nombre=" + nombre + ", numDepto=" + numDepto + "]";
	}
	
	
}
